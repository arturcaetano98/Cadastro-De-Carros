create database dbCarros;
use dbCarros;

create table Carros (
id INT PRIMARY KEY IDENTITY (1, 1),
marca VARCHAR(50),
modelo VARCHAR(50),
ano VARCHAR(9),
placa VARCHAR(8),
cor VARCHAR(50)); 

select * from Carros

drop database dbCarros;