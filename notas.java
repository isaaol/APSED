import java.util.Arrays;
import java.util.Random;

/**
  * Salve as notas que fizeram uma série
  * de alunos em várias disciplinas
  *
  */
public class Curso
{
    private static final int MAX_ESTUDANTES = 10;
    private static final int MAX_MATERIAS=  6;
    private int[][] notas;
    private Random gerador;

    /**
     * Construtor  
     */
    public Curso()   {
        this.gerador= new Random();
        notas = new int[MAX_MATERIAS][MAX_MATERIAS];
        inicializar(notas);
    }

    /**
      * Inicialize a matriz com notas aleatórias entre 1 e 10, inclusive
      * Usaremos um gerador
      */
    private void inicializar(int[][] notas)    {
        for (int fila = 0; fila <  notas.length; fila++)    {
            for (int col = 0; col <  notas[fila].length; col++)  {
                notas[fila][col] = gerador.nextInt(10) + 1;
            }
        }
    }

    public String toString() {
        String strResul = "Notas do curso\n";
        for (int fila = 0; fila <  notas.length; fila++)    {
            for (int col = 0; col <  notas[fila].length; col++)  {
                strResul += String.format("%4d", notas[fila][col]);
            }
            strResul += "\n";
        }
        return strResul;
    }
    /**
     *  Exibir na tela 
     * 
     */
    public void escrever( )
    {
        System.out.println(this.toString());
    }

    /**
     *  
        * Calcule a nota média por aluno
         * Passeio em linha
     * 
     */
    public double[] calcularMediaPorAluno()
    {
        double[] medias = new double[notas.length];
        for (int fila = 0; fila < notas.length; fila++)    {
            double suma = 0.0;
            for (int col = 0; col < notas[fila].length; col++)  {
                suma += notas[fila][col];
            }
            medias[fila] = suma / MAX_MATERIAS;
        }
        return medias;
    }

   
    public double[] calcularMediaPorMATERIAS()
    {
        double[] medias = new double[MAX_MATERIAS];
        for (int col = 0; col < notas[0].length; col++)  {
            double suma = 0.0;
            for (int fila = 0; fila < notas.length; fila++)    {
                suma += notas[fila][col];
            }
            medias[col] =  suma / MAX_ESTUDANTES ;
        }
        return medias;
    }

    
    public int suspensoesDeAluno(int aluno)
    {
        if (aluno < 0 || aluno >= notas.length) {
            throw new IllegalArgumentException("Error em nº alumno");
        }
        int suspensoes = 0;
        for (int col = 0; col < notas[aluno].length; col++) {
            if (notas[aluno][col] < 5)  {
                suspensoes ++;
            }
        }
        return suspensoes;

    }

    /**
     * @param MATERIAS nº de assinatura  
     *
     */

    public int aprovadosnamateria(int MATERIAS)
    {
        if (MATERIAS < 0 || matéria >= notas[0].length) {
            throw new Excecaodeargumentoilegal("Error em nº matéria");
        }
        int aprovados = 0;
        for (int fila = 0; fila < notas.length; fila++)   {
            if (notas[fila][MATERIAS] >= 5)  {
                aprovados ++;
            }
        }
        return aprovados;

    }

    /**
     * 
     */
    public static char[][] exemploirregular() {
        int[] longitudFilas = {4, 2, 5, 6};
        char[][] irregular = new char[4][];
        for (int fila = 0; fila < irregular.length; fila++) {
            irregular[fila] = new char[longitudFilas[fila]];
            for (int col = 0; col < irregular[fila].length; col++)  {
                irregular[fila][col] = 'X';
            }
        }
        return irregular;

    }

    
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.escribir();
        double[] mediasPorAlumno = curso.calcularMediaPorAluno();
        System.out.println("Media por aluno");
        System.out.println(Arrays.toString(mediasPorAlumno));
        double[] mediasPorMATERIAS = curso.calcularMediaPorMATERIAS();
        System.out.println("Media por MATERIAS");
        System.out.println(Arrays.toString(mediasPorMATERIAS));
        int aluno = 7;
        System.out.println("suspensoes de aluno " + aluno +
            " = " + curso.suspensoesDeAluno(aluno));
        int MATERIAS = 4;
        System.out.println("Aprovados em MATERIAS " +
        MATERIAS + " = " + curso.aprovadosnamateria(MATERIAS));

        System.out.println("Exemplo array desigual (irregular) ");
        char[][] irregular = Curso.exemploirregular();
        for (int fila = 0; fila < irregular.length; fila++)   {
            for (int col = 0; col < irregular[fila].length; col++)  {
                System.out.print(irregular[fila][col]);
            }
            System.out.println();
        }
    }

}
