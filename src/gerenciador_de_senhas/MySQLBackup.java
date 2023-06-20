package gerenciador_de_senhas;

import java.io.IOException;

/**
 *
 * @author fernando.oliveira
 */
public class MySQLBackup {
    private static final String MYSQL_PATH = "C:\\xampp\\mysql\\bin\\";
    private static final String DATABASE_NAME = "db_mstec";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Nando1287@";
    private static final String BACKUP_PATH = "C:\\path\\";
    
    public int realizarBackup(){
     try {
         
            // Define o nome do arquivo de backup com base na data e hora atual
            String fileName = "backup_" + System.currentTimeMillis() + ".sql";
            String filePath = BACKUP_PATH + fileName;
            
            System.out.print(fileName);
            // Constrói o comando para executar o backup
            String command = MYSQL_PATH + "mysqldump.exe" +
                    " --user=" + USERNAME +
                    " --password=" + PASSWORD +
                    " --databases " + DATABASE_NAME +
                    " --result-file=" + filePath;

            // Executa o comando para fazer o backup
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();

            // Verifica se o backup foi criado com sucesso
            if (exitCode == 0) {                
                System.out.println("Backup criado com sucesso: " + filePath);
                return exitCode;
            } else {
                
                System.out.println("Ocorreu um erro ao criar o backup.");
                return exitCode;
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return 100;
    }
}

