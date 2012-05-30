# Consumer OAuth para o Redu

Implementação de um consumer OAuth em Python para a API REST do [Redu]:(http://www.redu.com.br). Para criar esse consumer foram utilizados:

- Python 2.7
- Biblioteca [rauth](https://github.com/litl/rauth)

Este consumer tem o perfil de aplicação nativas definino do [RFC 2.10](http://tools.ietf.org/html/draft-ietf-oauth-v2-10#section-1.4.3) do OAuth2. Exemplos de consumers com o perfil Servidor Web, User-agent e Autonomo são bem vindo (pull-request us).

# Uso

Instale o rauth:

```
$ easy_install rauth
```

ou

```
$ pip install rauth
```

Altere o raquivo ``consumer.py`` colocando o seu ``consumer_key`` e ``consumer_secret`` nos devidos lugares. Caso ainda não possua estas chaves envie um e-mail para [contato@redu.com.br](mailto:contato@redu.com.br) requisitando.

Execute o arquivo ``consumer.py``:

```
$ python consumer.py
```
