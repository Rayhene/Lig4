package br.com.poli.lig4;

import br.com.poli.exceptions.ColunaOcupadaException;

/**
 *  Projeto de LPOO - Lig4 (Parte III)
 *  Dupla: Rayhene Ranúzia e Sarah Medeiros
 */
public class Tabuleiro {

    int x = 6, y = 7;
    int[][] tab = new int[x][y];

    public Tabuleiro() { //no construtor preenchemos todo o tabuleiro 6x7 com "0" em cada "casa"
        for (int linha = 0; linha < x; linha++) {
            for (int coluna = 0; coluna < y; coluna++) {
                tab[linha][coluna] = 0;
            }
        }
    }

    public int preencher(int posicaoX, int valor) throws ColunaOcupadaException { //esse método encontra uma posição vazia

        int linhaAux = 0; // a linha Auxiliar é para "escanear" a linha após a linha atual

        while (linhaAux < x && tab[linhaAux][posicaoX] == 0) { //o while é utilizado para incrementar a linha auxilixar que verifica se a próxima linha está vazia ou não
            linhaAux ++;
        }

        if (linhaAux != 0 ) { //se a próxima linha estiver vazia entao, um numero é printado nela, 1 ou 2 dependendo do valor jogador da vez
            this.tab[linhaAux -1][posicaoX] = valor;
            return linhaAux - 1; //retorna a posição Y que a peça ficou
        }
        else {
            System.out.println("A coluna " +posicaoX+ " já está preenchida. Jogue novamente."); //essa mensagem é printada caso a coluna escolhida ja esteja cheia e nao hajam posições disponiveis
            ColunaOcupadaException e = new ColunaOcupadaException();
            throw e;
        }
    }

    @Override
    public String toString() { //o toString aqui printa o tabuleiro bonitinho
        String str = " (0) (1) (2) (3) (4) (5) (6) \n"; //linha fixa
        for (int linha = 0; linha < x; linha++) {
            str += "|---.---.---.---.---.---.---|\n"; //linhas fixas
            for (int coluna = 0; coluna < y; coluna++) {
                if(tab[linha][coluna] == 0) { //o if é para quando o espaço tiver vazio
                    str += "|   ";
                }
                else {
                    str += "| " + tab[linha][coluna]+ " "; //o else é para quando tiver algum número printado (1 ou 2 no caso)
                }
            }
            str += "|\n";
        }
        str += "|===.===.===.===.===.===.===|"; //linha fixa
        return str; //retorna o tabuleiro
    }

    public int verificarHorizontal() {
        int j1=0, j2=0;

        //verificando as linhas
        for(int linha = 0; linha < x ; linha++){
            j1=0;
            j2=0;
            for(int coluna = 0; coluna < y ; coluna++) {
                if(this.tab[linha][coluna] == 1) {
                    j1++;
                    j2 = 0;

                }
                else if(this.tab[linha][coluna] == 2){
                    j2++;
                    j1 = 0;
                }
                else {
                    j1 = 0;
                    j2 = 0;
                }
                
                if(j1==4 || j2==4)
                    break;
            }
            if(j1 >= 4) {
                return 1;
            }
            else if (j2 >= 4) {
                return 2;
            }
        }
        return 0;
    }

    public int verificarVertical() {

        int j1 = 0, j2 = 0;
        // verificando as colunas
        for (int coluna = 0; coluna < y; coluna++) {
          j1 = 0;
          j2 = 0;
          for (int linha = 0; linha < x; linha++) {
            if (tab[linha][coluna] == 1) {
              j1++;
              j2 = 0;

            } else if (tab[linha][coluna] == 2) {
              j2++;
              j1 = 0;
            } else {
              j1 = 0;
              j2 = 0;
            }

            if (j1 >= 4) {
              return 1;
            } else if (j2 >= 4) {
              return 2;
            }
          }

        }
        return 0;
      }
     

    public int verificarDiagonal(int posicaoX, int posicaoY) {
        int j = 1;

        //verificando primeira diagonal

        int linha = posicaoX + 1;
        int coluna = posicaoY + 1;

        while(linha < x && coluna < y && tab[linha][coluna] == tab[posicaoX][posicaoY]) {
            j++;
            linha++;
            coluna++;
        }

        linha = posicaoX - 1;
        coluna = posicaoY - 1;

        while(linha >= 0 && coluna >= 0 && tab[linha][coluna] == tab[posicaoX][posicaoY]) {
            j++;
            linha--;
            coluna--;
        }

        if(j>= 4) {
            return tab[posicaoX][posicaoY];
        }

        //verificando a segunda diagonal

        j=1;

        linha = posicaoX + 1;
        coluna = posicaoY - 1;

        while(linha < x && coluna >= 0 && tab[linha][coluna] == tab[posicaoX][posicaoY]) {
            j++;
            linha++;
            coluna--;
        }

        linha = posicaoX - 1;
        coluna = posicaoY + 1;

        while(linha >= 0 && coluna < y && tab[linha][coluna] == tab[posicaoX][posicaoY]) {
            j++;
            linha--;
            coluna++;
        }

        if(j>= 4) {
            return tab[posicaoX][posicaoY];
        }

        return 0;

    }

    //verifica se teve empate, ou seja, se todos os campos do tabuleiro foram preenchidos sem um vencedor
//cada vez que há uma jogada, o método faz um loop pelo tabuleiro e adiciona +1 à variável "nonEmptyBlocks" caso uma jogada tenha sido realizada
//Se houverem 42 campos preenchidos(6x7) sem um vencedor, o método declara empate e sai do programa com status 0
    public boolean verificarEmpate() {
        int[][] posicoes = this.tab;
        int nonEmptySpaces = 0; //espaços que nao estão vazios
        for (int[] a : posicoes) {      //o array a contém todos os arrays da matriz posicoes
            for (int b : a) {           //o atributo b contem os elementos do array a
                if (b != 0) {           //se algum elemento b for diferente de 0, é porque nao existem mais espaços disponiveis (vazios)
                    nonEmptySpaces++;
                    if (nonEmptySpaces == 42) {
                        System.out.println("Empate! O jogo terminou.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}