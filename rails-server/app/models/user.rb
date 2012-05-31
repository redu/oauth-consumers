class User < ActiveRecord::Base
  attr_accessible :email, :login, :name, :uid, :token

  def self.create_with_omniauth(auth)
    create! do |user|
      user.uid = auth["uid"]
      user.name = auth["info"]["name"]
      user.login = auth["info"]["login"]
      user.email = auth["info"]["email"]
      user.token = auth["credentials"]["token"]
    end
  end
end
