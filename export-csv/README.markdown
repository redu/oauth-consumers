# Consumer OAuth para o Redu

Implementação de um consumer em Ruby para a API REST do [Redu](http://www.redu.com.br) que gera um CSV a partir dos posts do mural.

- Ruby 1.9.3
- Bundler

Este consumer tem o perfil de aplicação nativas definino do [RFC 2.10](http://tools.ietf.org/html/draft-ietf-oauth-v2-10#section-1.4.3) do OAuth2. Exemplos de consumers com o perfil Servidor Web, User-agent e Autonomo são bem vindo (pull-request us).

# Uso

Instale o oauth2:

```
$ bundle install
```

Altere o raquivo ``consumer.rb`` colocando o seu ``consumer_key`` e ``consumer_secret`` nos devidos lugares. Caso ainda não possua estas chaves envie um e-mail para [contato@redu.com.br](mailto:contato@redu.com.br) requisitando.

Execute o arquivo ``consumer.rb``:

```
$ ruby export.rb
```

# Estrutura de arquivos

```sh
export-csv (master) > tree .
.
├── Gemfile
├── Gemfile.lock
├── README.markdown
├── export.csv
├── export.rb
└── lib
    ├── authorization.rb
    ├── connection.rb
    └── csv_formatter.rb
```

- ``connection.rb`` responsável por realizar requisições HTTP para a API
- ``authorization.rb`` responsável por gerar o token da API
- ``csv_formatter.rb`` responsável por escrever o arquivo CSV
- ``export.rb`` arquivo principal

