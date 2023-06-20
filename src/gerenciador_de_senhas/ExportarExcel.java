///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package gerenciador_de_senhas;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import gerenciador_de_senhas.model.ModelUsuario;
//import dao.DaoUsuario;
//import java.sql.SQLException;
////import org.apache.poi.hssf.usermodel.HSSFSheet;
////import org.apache.poi.hssf.usermodel.HSSFWorkbook;
////import org.apache.poi.ss.usermodel.Cell;
////import org.apache.poi.ss.usermodel.Row;
//
///**
// *
// * @author fernando.oliveira
// */
//public class ExportarExcel {
//
//    static class Dados {
//
//        String nome;
//        String grupo;
//
//        public Dados() {
//        }
//
//        public Dados(String nome, String grupo) {
//            this.nome = nome;
//            this.grupo = grupo;
//        }
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        public String getGrupo() {
//            return grupo;
//        }
//
//        public void setGrupo(String grupo) {
//            this.grupo = grupo;
//        }
//
//        public static List<Dados> getDados() {
//            List<Dados> dados = new ArrayList<>();
//            dados.add(new Dados("Fernando", "Teste"));
//            dados.add(new Dados("Kaua", "teste"));
//            dados.add(new Dados("Juciane", ""));
//
//            return dados;
//        }
//
//        //OBTER LISTA 
//        public List<Dados> obterListaDados() throws IOException {
//
//            List<Dados> dados = new ArrayList();
//
//            String filename = "c:\\img\\dados.xls";
//            FileInputStream stream = new FileInputStream(filename);
//
//            HSSFWorkbook workbook = new HSSFWorkbook(stream);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator;
//            rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                if (row.getRowNum() == 0) {
//                    continue;
//                }
//
//                Iterator<Cell> cellIterator = row.cellIterator();
//                String grupo = "";
//                String nome = "";
//                while (cellIterator.hasNext()) {
//                //    Cell cell = cellIterator.next();
//                    switch (cell.getColumnIndex()) {
//                        case 0:
//                            nome = cell.getStringCellValue();
//                            break;
//                        case 1:
//                            grupo = cell.getStringCellValue();
//                            break;
//                    }
//                }
//                dados.add(new Dados(nome, grupo));
//            }
//
//            stream.close();
//
//            return dados;
//
//        }
//
//        //METODO PARA CRIAR LISTA
//        public void criaListaDados(List<ModelUsuario> dados, String nomeArquivo){
////            HSSFWorkbook workbook = new HSSFWorkbook();
////            HSSFSheet sheet = workbook.createSheet("Dados");
////            
////            int linha = 0;
////            for(ModelUsuario dado : dados){
////                Row row = sheet.createRow(linha++);
////                
////                int celula = 0;
////                Cell id = row.createCell(celula++);
////                id.setCellValue(dado.getId());
////                
////                Cell nome = row.createCell(celula++);
////                nome.setCellValue(dado.getNome());
////                
////                 Cell grupo = row.createCell(celula++);
////                grupo.setCellValue(dado.getGrupo()); 
////                
////                Cell maquina = row.createCell(celula++);
////                maquina.setCellValue(dado.getMaquina()); 
////                
////                Cell anydesk = row.createCell(celula++);
////                anydesk.setCellValue(dado.getAnydesk()); 
////                
////                Cell descricao = row.createCell(celula++);
////                descricao.setCellValue(dado.getDescricacao()); 
////                
////                Cell email = row.createCell(celula++);
////                email.setCellValue(dado.getEmail()); 
////                
////                Cell tag = row.createCell(celula++);
//                tag.setCellValue(dado.getTag()); 
//               
//            }
//            try {
//               FileOutputStream out = new FileOutputStream(new File(nomeArquivo));
//               workbook.write(out);
//               out.close();
//               System.out.println("Arquivo criado");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            
//        }
//        
//    }
//
//    public static void main(String[] args) throws IOException, SQLException {
//
//         Dados d = new Dados();
//        //d.obterListaDados();
//        DaoUsuario dao = new DaoUsuario();
//        List<ModelUsuario> listaUsuario = new ArrayList<>();
//        
//        listaUsuario = dao.getListaUsuarioDao("MS TECH");
//        
//        d.criaListaDados(listaUsuario, "c:\\img\\dados.csv");
//        
//    }
//
//}
