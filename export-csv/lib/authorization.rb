require "oauth2"
require "debugger"

class Authorization
  def initialize(options)
    @consumer_key = options[:consumer_key]
    @consumer_secret = options[:consumer_secret]
  end

  def authorize(&block)
    puts "Already have a PIN? [y/n]:"
    if gets.chomp == 'n'
      puts "Authorize: "
      puts oauth.auth_code.authorize_url
    end

    puts "Insert the pin: "
    pin = gets.chomp
    debugger
    token = oauth.auth_code.get_token(pin)
    @connection = Connection.new(oauth_token: token)

    yield(@connection) if block_given?
  end

  private

  def oauth
    @client ||= OAuth2::Client.new(@consumer_key, @consumer_secret,
                                   site: 'http://redu.com.br')
  end
end
