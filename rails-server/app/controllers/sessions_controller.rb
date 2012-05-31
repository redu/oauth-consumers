class SessionsController < ApplicationController
  def create
    @user ||=  User.create_with_omniauth(auth_hash)

    session[:user_id] = @user.id
    redirect_to user_path(@user, :format => :json)
  end

  protected

  def auth_hash
    request.env['omniauth.auth']
  end
end
