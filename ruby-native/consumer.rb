require "rubygems"
require "bundler/setup"
require "oauth2"

consumer_key ='your_consumer_key'
consumer_secret ='your_secret_key'

client = OAuth2::Client.new(consumer_key,
                            consumer_secret,
                            :site => 'http://redu.com.br')

puts "Already have a PIN? [y/n]:"
if gets.chomp == 'n'
  puts "Authorize: "
  puts client.auth_code.authorize_url
end

puts "Insert the pin: "
pin = gets.chomp
token = client.auth_code.get_token(pin)
puts "The Access Token is #{token.token}"
