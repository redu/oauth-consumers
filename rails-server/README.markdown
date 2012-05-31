# Consumer OAuth para o Redu

Implementação de um consumer OAuth2 em Ruby on Rails para a API REST do [Redu]:(http://www.redu.com.br). Para criar esse consumer foram utilizados:

- Ruby 1.8.7 (também compatível com 1.9.3)
- Rails 3.2.1
- [omniauth-redu](http://github.com/redu/omniauth-redu) 0.0.1.alpha

Este consumer tem o perfil de aplicação do tipo Web Application definido no [RFC](http://tools.ietf.org/html/draft-ietf-oauth-v2-26#section-2.1) do OAuth2.

# Uso

Baixe o código da aplicaçãom, instale as dependências e migre a base de dados:

```
cd rails-server
$ bundle install
$ bundle
```

Altere o arquivo ``config/initializers/omniauth.rb`` colocando seu ``consumer_key`` e ``consumer_secret`` nos devidos lugares. Pronto, sua aplicação Rails está configurada para negociar os tokens. Você só precisa iniciar o servidor:

```
$ rails s
```
Agora acesse http://0.0.0.0:3000/auth/redu para dar inicio a negociação dos tokens. No fim do processo será criado um User com o token, name, email, etc do usuário do Redu.

Para mais informações sobre este exemplo veja o [README](https://github.com/intridea/omniauth) do Gem omniauth ou assista [Railscast](http://railscasts.com/episodes/235-omniauth-part-1) sobre o assunto.
