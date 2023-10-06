#Author: rafaelaugusto.paiva@e2etreinamentos.com.br

@Regressivos @BuscarCEP
Feature: Busca por Endereco ou CEP 
  Como usuario do site dos correios
  Quero pesquisar um endereco ou CEP no site
  Para validar resultado da pesquisa
  
 Background: Acessar pagina inicial do site dos correios
 Given que acesso o site dos correios
  
  @CT01
  Scenario Outline: Buscar um novo CEP
    When envio dado para busca
    Then valido o retorno da consulta
    
		