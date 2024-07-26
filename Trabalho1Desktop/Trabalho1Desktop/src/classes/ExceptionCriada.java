/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author marin
 */
public class ExceptionCriada extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExceptionCriada(String texto){
		super(texto);
	}
}
