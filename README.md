# 📚 Event-Driven Application in Spring Boot

Este é um exemplo simples de uma aplicação orientada a eventos em Java utilizando Spring Boot. A aplicação demonstra como usar os mecanismos de publicação e escuta de eventos do Spring.

## 🗂️ Estrutura do Projeto

- **events**: Contém a classe que representa o evento (`OrderCreatedEvent`).
- **publisher**: Contém a classe responsável por publicar eventos (`OrderEventPublisher`).
- **listener**: Contém a classe que escuta e processa os eventos (`OrderEventListener`).
- **controller**: Contém o ponto de entrada para criar pedidos e disparar eventos (`OrderController`).
- **EventDemoApplication**: Classe principal para inicializar a aplicação.

## 🚀 Como Rodar o Projeto


1. **Compile o projeto**:
           ```bash
           mvn clean install
           ```

2. **Execute a aplicação**:
           ```bash
           mvn spring-boot:run
           ```

3. **Faça uma requisição POST para criar um pedido**:
           ```bash
           curl -X POST "http://localhost:8080/orders?orderId=12345"
           ```

4. **Verifique o console**:
- Você verá a mensagem do listener processando o evento.

## 🧪 Testes

1. **Execute os testes unitários e de integração**:
           ```bash
           mvn test
           ```

2. **Verifique os resultados no console ou no relatório gerado**.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal.
- **Spring Boot**: Framework para simplificar o desenvolvimento.
- **Maven**: Gerenciador de dependências e build.
- **JUnit 5**: Framework de testes.

## 📄 Licença

Este projeto é apenas um exemplo educacional e não possui uma licença específica. Sinta-se à vontade para usá-lo como base para seus próprios projetos.

## ✨ Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

---
Feito com ❤️ por Anderson Gadelha.