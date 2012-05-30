from rauth.service import OAuth2Service

# Get a real consumer key & secret from:
redu = OAuth2Service(
        name='redu',
        authorize_url='http://redu.com.br/oauth/authorize',
        access_token_url='http://redu.com.br/oauth/token',
        consumer_key='consumer_key',
        consumer_secret='secret_key')

print 'Visit this URL in your browser: ' +  redu.get_authorize_url()

# This is a bit cumbersome, but you need to copy the code=something (just the
# `something` part) out of the URL that's redirected to AFTER you login and
# authorize the demo application
code = raw_input('Enter the PIN: ')

# create a dictionary for the data we'll post on the get_access_token request
data = dict(code=code,
            grant_type='authorization_code',
            redirect_uri='')
# retrieve the access token
access_token = \
        redu.get_access_token('POST', data=data).content['access_token']

print 'The access token is: ' + access_token
