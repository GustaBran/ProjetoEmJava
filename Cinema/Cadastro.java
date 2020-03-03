import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class relembrando extends JPanel {
	private JLabel lbTitulo,lbNome,lbAno,lbGen,lbCod,lbDis,lbImg,lbMNome,lbMAno,lbMGen;
	private JTextField tfNome,tfAno, tfCod;
	private JComboBox cbGen;
	private JRadioButton rbDis,rbNDis;
	private ButtonGroup btGrupo;
	private JButton btCadastrar,btAssistir, btVer;
	private JPanel pnPrinc,pnFilmes,pnTable;
	private ImageIcon imgPop,rambo,pulp,hp,cideus,debi;

	
	private JTable table;
	private JScrollPane scrollTable; 
	
	public relembrando() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		
		lbTitulo = new JLabel("<html><h2>CADASTRO DE FILMES</h2></html>");
		lbTitulo.setBounds(150, 10, 230, 24);
		
		lbNome = new JLabel("Nome:");
		lbNome.setBounds(30, 50, 150, 20);
		tfNome = new JTextField ();
		tfNome.setBounds(70, 50, 140, 18);
		
		lbAno = new JLabel("Ano:");
		lbAno.setBounds(30,85,60,20);
		tfAno = new JTextField();
		tfAno.setBounds(60,85,50,18);
		
		lbCod = new JLabel("Código:");
		lbCod.setBounds(120,85,60,20);
		tfCod = new JTextField();
		tfCod.setBounds(170,85,40,18);
		
		lbGen = new JLabel("Gênero:");
		lbGen.setBounds(30,120,60,20);
		
		String [] Genero = {"Ação","Aventura", "Comédia", "Drama","Romance"};
		cbGen = new JComboBox (Genero);
		cbGen.setBounds(80,120,130,20);
		
		lbDis = new JLabel ("Disponibilide:");
		lbDis.setBounds(30,155,130,20);
		
		rbDis = new JRadioButton("Disponivel");
		rbNDis = new JRadioButton("Indisponivel");
		
		btGrupo = new ButtonGroup();
		btGrupo.add(rbDis);
		btGrupo.add(rbNDis);
		
		rbDis.setBounds(110,155,100,20);
		rbNDis.setBounds(110,175,100,20);
		rbDis.setSelected(true);
		
		btCadastrar = new JButton ("<html><h3>Cadastrar</h3></html>");
		btCadastrar.setBounds(30,222,180,45);
		
		btVer = new JButton ("<html><h3>VER</h3></html>");
		btVer.setBounds(220,227,60,30);
		btVer.setEnabled(false);
		
		pnFilmes = new JPanel(new BorderLayout());
		pnFilmes.setBorder(new TitledBorder("Filme"));
		pnFilmes.setBounds(290,40,180,230);
		
		imgPop = new ImageIcon ("C:\\Users\\Rod\\Desktop\\Pop.png");
		
		rambo  = new ImageIcon ("C:\\Users\\Rod\\Desktop\\rambo.png");
		pulp   = new ImageIcon ("C:\\Users\\Rod\\Desktop\\pulp.png");
		hp     = new ImageIcon ("C:\\Users\\Rod\\Desktop\\hp.png");
		cideus = new ImageIcon ("C:\\Users\\Rod\\Desktop\\cideus.png");
		debi   = new ImageIcon ("C:\\Users\\Rod\\Desktop\\debi.png");
		
		lbImg = new JLabel(imgPop);
		lbImg.setBounds(30,20,115,130);
		
		lbMNome = new JLabel ("Selecione um Filme");
		lbMNome.setBounds(30,150,115,20);
		lbMAno = new JLabel ("Ano");
		lbMAno.setBounds(30,165,30,20);
		lbMGen = new JLabel ("Gênero");
		lbMGen.setBounds(67,165,70,20);
		btAssistir = new JButton ("Assistido");
		btAssistir.setBounds(30,190,115,25);
		btAssistir.setEnabled(false);
		pnPrinc = new JPanel();
		pnPrinc.setLayout(null);
		pnPrinc.setBounds(0, 0, 530,500);
		
		pnPrinc.add(lbTitulo);
		pnPrinc.add(lbNome);
		pnPrinc.add(tfNome);
		pnPrinc.add(lbAno);
		pnPrinc.add(tfAno);
		pnPrinc.add(lbCod);
		pnPrinc.add(tfCod);
		pnPrinc.add(lbGen);
		pnPrinc.add(cbGen);
		pnPrinc.add(lbDis);
		pnPrinc.add(rbDis);
		pnPrinc.add(rbNDis);
		pnPrinc.add(btCadastrar);
		pnPrinc.add(btVer);
		pnPrinc.add(pnFilmes);
		pnFilmes.setLayout(null);
		pnFilmes.add(lbImg);
		pnFilmes.add(lbMNome);
		pnFilmes.add(lbMAno);
		pnFilmes.add(lbMGen);
		pnFilmes.add(btAssistir);
		Numeros(tfAno);
		Numeros(tfCod);
		
		pnTable = new JPanel(new BorderLayout());
		scrollTable = new JScrollPane();
		
		
		DefaultTableModel tableModel = new DefaultTableModel(
			new String[] {"Cód", "Nome", "Ano", "Gênero", "Disp", },0) {
			public boolean isCellEditable(int row, int col) { 
				if (col == 0 || col == 4 ) {
					return true;
				}
				return false;
			}
		};
		table = new JTable(tableModel);
		DefaultTableCellRenderer Center = new DefaultTableCellRenderer(); 
		Center.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
		table.getColumnModel().getColumn(4).setCellRenderer(Center);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTable.setViewportView(table);
		pnTable.add(scrollTable);
		pnTable.setBounds(30, 290, 438, 200);
		pnPrinc.add(pnTable);
		add(pnPrinc);
	
		
		
	}

	private void definirEventos(){
		
		btCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tfNome.getText().equals("") || tfAno.getText().equals("") || tfCod.getText().equals("") ){
				JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos");
				return;
			}
				
			String Dispo = "SIM";
			String Genero = "Genero";
			
			if(cbGen.getSelectedIndex()==0){
				Genero = "Ação";
			}	
			if(cbGen.getSelectedIndex()==1){
				Genero = "Aventura";
			}		
			if(cbGen.getSelectedIndex()==2){
				Genero = "Comedia";
			}	
			if(cbGen.getSelectedIndex()==3){
				Genero = "Drama";
			}	
			if(cbGen.getSelectedIndex()==4){
				Genero = "Romance";
			}	
				
			if(rbNDis.isSelected()){Dispo = "NÃO";}
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(new Object[] {tfCod.getText(),tfNome.getText(), tfAno.getText(),Genero, Dispo});
			
			tfNome.setText("");
			tfAno.setText("");
			tfCod.setText("");
			
		}});
		
		btAssistir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int[] linhas = table.getSelectedRows();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for(int i = (linhas.length -1 ); i>=0; --i){ //esse for percorre o vetor de linhas , verifica qual  linha é selecionada e exclui
					dtm.removeRow(linhas[i]);
				}
	
			}
		});
		
		btVer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nome   = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,1));
		    	String ano    = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,2));
		    	String Genero = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,3));
		    	String Dispo  = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,4));
		    	lbMNome.setText(nome);
		    	lbMAno.setText(ano);
		    	lbMGen.setText(Genero);
    	
		    	lbImg.setIcon(imgPop);
		    	if(Dispo.equals("SIM")) {btAssistir.setEnabled(true);}
		    	if(Dispo.equals("NÃO")) {btAssistir.setEnabled(false);}
		    	if(nome.equals("Rambo")){lbImg.setIcon(rambo);}
		    	if(nome.equals("Harry Potter")){lbImg.setIcon(hp);}
		    	if(nome.equals("Pulp Fiction")) {lbImg.setIcon(pulp);}
		    	if(nome.equals("Debi e Loide")) {lbImg.setIcon(debi);}
		    	if(nome.equals("Cidade de Deus")) {lbImg.setIcon(cideus);}
		    	
			}		
		});
		
		/*table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent e) {
	        	String nome   = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,1));
	        	String ano    = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,2));
	        	String Genero = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,3));
	        	String Dispo  = String.valueOf(table.getModel().getValueAt( table.getSelectedRow() ,4));
	        	lbMNome.setText(nome);
	        	lbMAno.setText(ano);
	        	lbMGen.setText(Genero);
	        	
	        	//if(Dispo.equals("SIM")) {btAssistir.setEnabled(true);} else{btAssistir.setEnabled(false);}
	        }
	    });*/
		
		table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent e) {
	        	btVer.setEnabled(true);
	        	btAssistir.setEnabled(false);
	        }});
	}
	
	public void Numeros(JTextField a){
		a.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					String resp = "Por favor, digite somente números.";
					JOptionPane.showMessageDialog(pnTable,resp);
				}
			}
		});
	}
	public static void main(String args[]){
 		JFrame frame = new JFrame("Area de Texto");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(new relembrando());
		 frame.setBounds(300,300,530,560);
		 frame.setVisible(true);
		 
	 }
}
