package dao;

import java.util.Scanner;

public class Principal {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		int menu=0;
		int qtdUsuarios = 6;
		String nome = "", senha = "";
		char sexo;
		int idade;
		
		Usuario usuario = new Usuario();
		
		while(menu < 5) {
			
			//Escolha do usuario
			System.out.println("Digite sua opção:");
			System.out.println(" 1 Listar \n 2 Inserir \n 3 Excluir \n 4 Atualizar \n5 Sair");
			menu = sc.nextInt();
			
			
			//Menu
			switch(menu) {
				case 1:
					Usuario[] usuarios = dao.getUsuarios();
					for(int i = 0; i < usuarios.length; i++) {
						System.out.println(usuarios[i].toString());
					break;
					}
					
					
				case 2:
					qtdUsuarios ++;
					
					System.out.println("Digite o nome, senha, sexo e idade do usuario:");
					nome = sc.next();
					senha = sc.next();
					sexo = sc.next().charAt(0);
					idade = sc.nextInt();
					
					usuario = (qtdUsuarios, nome, senha, sexo, idade);
					if(dao.inserirUsuario(usuario) == true) {
						System.out.println("Inserção com sucesso -> " + usuario.toString());
					}
					break;
					
				
				case 3:
					dao.excluirUsuario(usuario.getCodigo());
					break;
					
					
				case 4: 
					System.out.println("Digite o novo nome, senha, sexo e idade do usuario:");
					nome = sc.next();
					senha = sc.next();
					sexo = sc.next().charAt(0);
					idade = sc.nextInt();
					
					usuario.setLogin(nome);
					usuario.setSenha(senha);
					usuario.setSexo(sexo);
					usuario.setIdade(idade);
					
					dao.atualizarUsuario(usuario);
					break;
					
				default:
					System.out.println("Saindo...");
					
			}
			
		}
		
		dao.close();
	}
}