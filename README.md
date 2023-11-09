## ChallengeEnterprise

# Médicos

**Método** :  * *GET* *

Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
  - 200 OK: Retorna todos os médicos cadastrados.
  - 204 No Content: Não há médicos cadastrados.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

  Descrição: Retorna uma lista de todos os médicos cadastrados na aplicação.

**Método** :  * *GET - POR ID* *

Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
  - 200 OK: Retorna as informações do médico escolhido pelo ID.
  - 204 No Content: Médico não encontrado.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

 Descrição: Retorna as informações de um médico com base no ID fornecido.

**Método** :  * *POST* *

 Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
  - 201 Created: Médico cadastrado com sucesso.
  - 400 Bad Request: Erro na emissão do cabeçalho ou do corpo da requisição.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

 Descrição: Cadastra um novo médico com as informações fornecidas.

**Método** :  * *PUT* *

 Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
 Respostas:
  - 200 OK: Médico atualizado com sucesso.
  - 400 Bad Request: Erro na atualização do médico.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

 Descrição: Atualiza as informações do médico com base nas informações fornecidas.

**Método** :  * *POST - Login* *

Header: Content-Type: application/json
Respostas:
  - 200 OK: Login bem-sucedido.
  - 400 Bad Request: Erro na emissão do cabeçalho ou do corpo da requisição ou credenciais inválidas.
  - 500 Internal Server Error: Erro interno inesperado.
    
Descrição: Permite que o médico faça login em sua conta.


# Prontuários

**Método** :  * *GET* *

 Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
  - 200 OK: Retorna todos os prontuários cadastrados.
  - 204 No Content: Não existem prontuários.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

  Descrição: Devolve todos os prontuários cadastrados na aplicação.

**Método** :  * *POST* *

Header: Content-Type: application/json
Respostas:
  - 200 OK: Cadastro bem-sucedido.
  - 400 Bad Request: Erro na emissão do cabeçalho ou do corpo da requisição ou campos inválidos.
  - 500 Internal Server Error: Erro interno inesperado.
  - 
Descrição: Cadastra os prontuários na aplicação.

**Método** :  * *PUT* *

  Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
    - 200 OK: Prontuário atualizado com sucesso.
    - 400 Bad Request: Erro na atualização do prontuário.
    - 401 Unauthorized: Não autorizado (não logado).
    - 500 Internal Server Error: Erro interno inesperado.
    
  -Descrição: Permite que o médico atualize as informações do prontuário.

# Pacientes

**Método** :  * *GET* *

Cabeçalho: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
  - 200 OK: Retorna todos os pacientes cadastrados.
  - 204 No Content: Não existem pacientes.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

  Descrição: Devolve todos os pacientes cadastrados na aplicação.

**Método** :  * *POST* *

Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
 Respostas:
  - 201 Created: Paciente cadastrado com sucesso.
  - 400 Bad Request: Erro na emissão do cabeçalho ou do corpo da requisição.
  - 401 Unauthorized: Não autorizado (não logado).
  - 500 Internal Server Error: Erro interno inesperado.

  Descrição: Cadastra um novo paciente com as informações fornecidas.

**Método** :  * *GET - POR ID* *

Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
 Respostas:
    - 200 OK: Retorna o paciente escolhido com base no ID.
    - 204 No Content: Paciente não encontrado.
    - 401 Unauthorized: Não autorizado (não logado).
    - 500 Internal Server Error: Erro interno inesperado.
    
  Descrição: Devolve o paciente cujo ID é recebido no path.
  
**Método** :  * *PUT* *

Header: Content-Type: application/json Authorization: Bearer {chave de identificação do usuário da health-sync}
  Respostas:
    - 200 OK: O paciente foi atualizado com sucesso.
    - 400 Bad Request: Erro na atualização do paciente.
    - 401 Unauthorized: Não autorizado (não logado).
    - 500 Internal Server Error: Erro interno inesperado ou quando a OpenAI API responder com um código 500.
    
 Descrição: Serve como intermediário entre o usuário e a OpenAI API para atualizar o paciente.

**Método** :  * *POST - Login* *

 Header: Content-Type: application/json
  Respostas:
    - 200 OK: Login bem-sucedido.
    - 400 Bad Request: Erro na emissão do cabeçalho ou do corpo da requisição ou credenciais inválidas.
    - 401 Unauthorized: Credenciais inválidas.
    - 500 Internal Server Error: Erro interno inesperado.
    
  Descrição: Permite que um paciente faça login em sua conta.

  
