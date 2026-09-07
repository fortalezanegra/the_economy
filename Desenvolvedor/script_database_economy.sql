/*###########################################################################################################
#########################    S C R I P T   D A T A B A S E   T H E  E C O N O M Y   #########################
###########################################################################################################*/

/* Removendo banco se existir */
DROP DATABASE IF EXISTS economy;

/* Criando Banco de Dados */
CREATE DATABASE economy
  DEFAULT CHARACTER SET utf8mb4 
  COLLATE utf8mb4_unicode_ci;

/* Selecionando Banco */
USE economy;