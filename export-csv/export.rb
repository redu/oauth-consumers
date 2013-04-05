# encoding: utf-8

require "rubygems"
require "bundler/setup"

require "./lib/csv_formatter"
require "./lib/connection"
require "./lib/authorization"

redu = Authorization.new(consumer_key: ENV['REDU_KEY'], consumer_secret:  ENV['REDU_SECRET'])

redu.authorize do |connection|
  formatter = CSVFormatter.new("Autor", "Texto")
  link = connection.get("me").body["links"].find { |link| link["rel"] == "timeline" }

  formatter.generate do |csv|
    connection.get(link["href"], :type => 'Activity').body.each do |status|
      csv << [status["user"]["first_name"], status["text"]]
    end
  end
end



