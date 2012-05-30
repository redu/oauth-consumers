# Consumer OAuth para o Redu

Implementação de um consumer OAuth em Ruby para a API REST do [Redu]:(http://www.redu.com.br). Para criar esse consumer foram utilizados:

- Ruby 1.8.7 (também compatível com 1.9.3)
- Gem [oauth2](https://github.com/intridea/oauth2)

Este consumer tem o perfil de aplicação nativas definino do [RFC 2.10](http://tools.ietf.org/html/draft-ietf-oauth-v2-10#section-1.4.3) do OAuth2. Exemplos de consumers com o perfil Servidor Web, User-agent e Autonomo são bem vindo (pull-request us).

# Uso

Instale o oauth2:

```
$ bundle install
```

ou

```
$ gem install oauth2
```

Altere o raquivo ``consumer.rb`` colocando o seu ``consumer_key`` e ``consumer_secret`` nos devidos lugares. Caso ainda não possua estas chaves envie um e-mail para [contato@redu.com.br](mailto:contato@redu.com.br) requisitando.

Execute o arquivo ``consumer.rb``:

```
$ ruby consumer.py
```

