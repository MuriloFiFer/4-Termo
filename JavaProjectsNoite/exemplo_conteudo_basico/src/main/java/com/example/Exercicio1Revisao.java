package com.example;

import java.util.Scanner;

public class Exercicio1Revisao {
    
    //atributos
    double[] notas = new double[4];
    double media = 0;
    boolean bonus = false; // Verifica se todas as notas são maiores que 9 e aplica bonus


    //metodos
    public void calculoMedia(){
        Scanner sc = new Scanner(System.in);
        //receber as notas
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a Nota "+(i+1)+":");
            notas[i]=sc.nextDouble();
            media+=notas[i]; //Acumula o valor das notas 
    }
    //calcular a media
    media=media/notas.length;

    //verificar a media
    if (notas[0]>=9 && notas[1]>= 9 && notas[2]>=9 && notas[3]>=9) {
        media = (media*1.1>10?media=10:media*1.1);
        //se media for maior que 10        
    }

    //printar Resultado
    if (media>7) {
        System.out.println("A média do Aluno é %.2f\n"+media+" resultado Aprovado");
    }else if(media>=5 && media<7){
        System.out.println("A média do Aluno é %.2f\n"+media+" resultado Recuperação");
    }else{
        System.out.println("A média do Aluno é %.2f\n"+media+" resultado Reprovado");
    }

    
}

};