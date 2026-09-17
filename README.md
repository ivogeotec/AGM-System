# AGM System - Sistema de Gestão e Logística de Equipamentos

## Status do Projeto
> Em desenvolvimento

## Tecnologias Aplicadas
* **Linguagem:** Java (JDK)
* **Interface Gráfica:** Java Swing
* **Ambiente de Desenvolvimento (IDE):** Apache NetBeans
* **Banco de Dados:** MySQL Server e MySQL Workbench
* **Conectividade:** Driver JDBC (MySQL Connector/J)
* **Controle de Versão:** Git e GitHub

## Desenvolvido por:
* Antônio Ivo Gomes Barbosa

## Objetivo do Software
O **AGM System** é uma aplicação desktop desenvolvida para gerenciar contratos de locação de máquinas e ferramentas para a construção civil, otimizando o controle de inventário e a logística de entrega por meio do registro de coordenadas geográficas de clientes e canteiros de obras.

## Funcionalidades do Sistema (Requisitos)
* **Gestão de Clientes:** Cadastro e listagem de clientes com identificação, contato e resolução espacial de endereço.
* **Controle de Inventário:** Cadastro, monitoramento de valores diários e status de disponibilidade dos equipamentos (Disponível, Alugado, Em Manutenção).
* **Gestão de Contratos de Locação:** Abertura e vínculo entre cliente, equipamento e local da obra, com validação temporal de datas de início e término.
* **Persistência Relacional:** Gravação e consulta de dados transacionais via arquitetura DAO conectada a banco de dados MySQL.