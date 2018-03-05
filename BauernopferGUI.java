import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BauernopferGUI {

	protected Shell shell;
	private Table table;
	private Button btnSetzen;
	private Button btnPlay;
	private Button btnRestart;
	private Button btnSpielen2;
	private Button btnSetzen2;
	Bauernopfer bf = new Bauernopfer();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BauernopferGUI window = new BauernopferGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(292, 220);
		shell.setText("Bauernopfer");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, -13, 183, 180);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		for (int i = 0;i< 8;i++) {
			TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
			tblclmnNewColumn.setWidth(22);
			tblclmnNewColumn.setText("");
			}
		int temp = 0;
		int zaehler = 1;
		for (int i = 0;i< 8;i++) {
		TableItem tableItem = new TableItem(table, SWT.NONE);
		for (int i1 = 0;i1< 4;i1++) {
		tableItem.setBackground(i1+temp, SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		tableItem.setText("");
		temp++;
		}
		if(zaehler == 2) { 
		temp = 0;
		zaehler = 1;
		}
		else{
		temp = 1;
		zaehler = 2;
		}
		}
		
		
		
		
		btnPlay = new Button(shell, SWT.NONE);
		btnPlay.setBounds(199, 41, 75, 25);
		btnPlay.setText("Spielen1");
		btnPlay.addListener(SWT.Selection, new Listener(){
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				    bf.TurmPosX = 0;
				    bf.TurmPosY = 7;
				    bf.BauerPosY = 3;
				    int temp = 0; 
				    
				    //Bewegen
				    while (bf.capture != true ) { 
				      if (bf.Schachbrett[bf.TurmPosX][bf.TurmPosY-1] == bf.Bauer && bf.Schachbrett[bf.TurmPosX-1][bf.TurmPosY] == bf.Bauer) {
				        bf.capture = true; 
				      } // end of if
				      
				      else {
				        
				        //Bauer Zug
				        if (bf.Bmove == true) {
				          if (bf.Schachbrett[bf.TurmPosX][bf.TurmPosY-1] == bf.Bauer) {
				            while (temp < 7) { 
				            	bf.BauerPosY = 0;
				            	bf.Schachbrett [bf.BauerPosY+ temp][bf.TurmPosY-1] = 0;
				            	bf.Schachbrett [bf.BauerPosY+ temp][bf.TurmPosY] = bf.Bauer;
				              temp++;      
				            } // end of while
				          } // end of if
				          else {
				        	  bf.Schachbrett [bf.TurmPosX+temp][bf.BauerPosY-1] = 0;
				        	  bf.Schachbrett [bf.TurmPosX+temp][bf.BauerPosY] = bf.Bauer;
				          } // end of if-else
				         
				          bf.Bmove = false;
				          bf.Tmove = true;   
				          bf.Züge++;
				          for (int i = 0;i< 8;i++) {
								
						      for (int i3 = 0;i3< 8;i3++) {
						    	  if(bf.Schachbrett[i][i3]==1) {
											TableItem row = table.getItem(i);
											row.setText(i3, "B");
											
						    	  }
						    	  else {
						    		  TableItem row = table.getItem(i);
										row.setText(i3, " ");  
						    	  }
						      }
						}
				          System.out.println("");
				          for (int i1 = 0;i1< 8 ;i1++) {
				              System.out.println("");
				              for (int i2 = 0;i2< 8;i2++) {
				                System.out.print(bf.Schachbrett[i1][i2] + " "); 
				              } // end of for
				            } // end of for 
				          
				        } // end of if    
				        
				        //Turm Zug
				        if (bf.Tmove == true ) { 
				          if (bf.Schachbrett[bf.TurmPosX][bf.TurmPosY-1] == bf.Bauer && bf.Schachbrett[7][7] != bf.Turm) {
				        	  bf.Schachbrett [bf.TurmPosX][bf.TurmPosY] = 0;
				        	  bf.TurmPosX = bf.TurmPosX+1;
				        	  bf.Schachbrett [bf.TurmPosX][bf.TurmPosY] = bf.Turm;
				          } // end of if
				          else {
				            if (temp+bf.TurmPosX >= 7) {
				              temp = 0;
				              bf.BauerPosY++;
				            } // end of if
				            else {
				              temp++;
				            } // end of if-else
				            
				          } // end of if-else
				          bf.Bmove = true;     
				          bf.Tmove = false; 
				          bf.Züge++;
				          for (int i = 0;i< 8;i++) {
								
						      for (int i3 = 0;i3< 8;i3++) {
						    	  if(i==bf.TurmPosX && i3 == bf.TurmPosY) {
											TableItem row = table.getItem(i);
											row.setText(i3, "T");
											
											
						    	  }
						    	  
						      }
						
						}
				          System.out.println("");
				          for (int i1 = 0;i1< 8 ;i1++) {
				              System.out.println("");
				              for (int i2 = 0;i2< 8;i2++) {
				                System.out.print(bf.Schachbrett[i1][i2] + " "); 
				              } // end of for
				            } // end of for
				          
							
				        } // end of if
				        
				      } // end of if-else
				      
				    } // end of while
			
			}
	    });
		
		
		btnSetzen = new Button(shell, SWT.NONE);
		btnSetzen.setBounds(199, 10, 75, 25);
		btnSetzen.setText("Setzen1");
		btnSetzen.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				bf.setzen1();
				
				for (int i = 0;i< 8;i++) {
				
				      for (int i3 = 0;i3< 8;i3++) {
				    	  if(bf.Schachbrett[i][i3]==1) {
									TableItem row = table.getItem(i);
									row.setText(i3, "B");
									
				    	  }
				    	  if(i==bf.TurmPosX && i3 == bf.TurmPosY) {
									TableItem row = table.getItem(i);
									row.setText(i3, "T");
									
				    	  }
				      }
				
				}
			}
		    });
		
		
		btnRestart = new Button(shell, SWT.NONE);
		btnRestart .setBounds(199, 72, 75, 25);
		btnRestart .setText("Restart");
		btnRestart .addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bf.createSchachbrett();
				table.dispose();
				table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
				table.setBounds(10, -13, 183, 180);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				for (int i = 0;i< 8;i++) {
					TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
					tblclmnNewColumn.setWidth(22);
					tblclmnNewColumn.setText("");
					}
				int temp = 0;
				int zaehler = 1;
				for (int i = 0;i< 8;i++) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				for (int i1 = 0;i1< 4;i1++) {
				tableItem.setBackground(i1+temp, SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
				tableItem.setText("");
				temp++;
				}
				if(zaehler == 2) { 
				temp = 0;
				zaehler = 1;
				}
				else{
				temp = 1;
				zaehler = 2;
				}
				}
			}
		});
		
		
		
		btnSpielen2 = new Button(shell, SWT.NONE);
		btnSpielen2.setBounds(199, 134, 75, 25);
		btnSpielen2.setText("Spielen2");
		btnSpielen2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bf.TurmPosX = 7;
			    bf.TurmPosY = 0;
			    bf.BauerPosY = 6;
			    int temp = 0;
			    int temp2 = 0;
			    boolean check = false;
			    
			    
			    
			    while (bf.capture != true) { 
			      if (bf.Schachbrett[bf.TurmPosX][bf.TurmPosY+1] == bf.Bauer && bf.Schachbrett[bf.TurmPosX-1][bf.TurmPosY] == bf.Bauer) {
			    	  bf.capture = true;
			      } // end of if
			      
			      else {  
			        
			        for (int i = 0;i< 8 ;i++ ) {
			          if (bf.Schachbrett[bf.TurmPosX][i] == bf.Bauer) {
			            check = true;
			            i = 8;
			          } // end of if
			          else {    
			            check = false;
			          } // end of if-else
			        } // end of for 
			        
			        // Zug Bauer
			        if (bf.Bmove == true) {
			          if (check != true) {
			        	  bf.Schachbrett[bf.TurmPosX-1][bf.BauerPosY-temp] = 0;
			        	  bf.Schachbrett[bf.TurmPosX][bf.BauerPosY-temp] = bf.Bauer;
			            temp++;
			          } // end of if
			          else {
			            if (bf.Schachbrett[temp2][bf.BauerPosY] == bf.Bauer && bf.Schachbrett[temp2+2][bf.BauerPosY+1] == bf.Bauer ) {
			            	bf.Schachbrett[temp2][bf.BauerPosY] = 0;
			              temp2 += +1;
			              bf.Schachbrett[temp2][bf.BauerPosY] = bf.Bauer;
			              bf.BauerPosY++;
			              temp += 2;
			            } // end of if
			            else {
			              if (temp + 1 <= 7) {  
			            	  bf.Schachbrett[temp][bf.BauerPosY] = 0;
			                temp++;
			                bf.Schachbrett[temp][bf.BauerPosY] = bf.Bauer;
			                bf.BauerPosY++;
			                
			              } // end of if
			              else {
			            	  bf.BauerPosY = 0;
			            	  bf.Schachbrett[temp2][bf.BauerPosY] = 0;
			                temp2++;
			                bf.Schachbrett[temp2][bf.BauerPosY] = bf.Bauer;
			                bf.BauerPosY++;
			                temp = temp2+1;   
			              } // end of if-else
			            } // end of if-else
			              
			          } // end of if-else
			          bf.Bmove = false;
			          bf.Tmove = true;
			          for (int i = 0;i< 8;i++) {
							
					      for (int i3 = 0;i3< 8;i3++) {
					    	  if(bf.Schachbrett[i][i3]==1) {
										TableItem row = table.getItem(i);
										row.setText(i3, "B");
										
					    	  }
					    	  else {
					    		  TableItem row = table.getItem(i);
									row.setText(i3, " ");  
					    	  }
					      }
					}
			          System.out.println("");
			          for (int i1 = 0;i1< 8 ;i1++) {
			              System.out.println("");
			              for (int i2 = 0;i2< 8;i2++) {
			                System.out.print(bf.Schachbrett[i1][i2] + " "); 
			              } // end of for
			            } // end of for 
			          
			        } // end of if
			        
			        
			        // Zug Turm
			        if (bf.Tmove == true) {
			          if (check != true) {
			            if (bf.Schachbrett[bf.TurmPosX-2][bf.TurmPosY] == bf.Bauer) {
			            	bf.Schachbrett[bf.TurmPosX][bf.TurmPosY] = 0;
			            	bf.TurmPosX = 7;
			            	bf.Schachbrett[bf.TurmPosX][bf.TurmPosY] = bf.Turm;
			            	bf.BauerPosY = 0;
			              temp = 0;
			              temp2 = temp;
			              
			            } // end of if
			            else {
			            	bf.Schachbrett[bf.TurmPosX][bf.TurmPosY] = 0;
			            	bf.TurmPosX -= 1;
			              bf.Schachbrett[bf.TurmPosX][bf.TurmPosY] = bf.Turm; 
			            } // end of if-else
			          } // end of if
			          bf.Bmove = true;
			          bf.Tmove = false;
			          for (int i = 0;i< 8;i++) {
							
					      for (int i3 = 0;i3< 8;i3++) {
					    	  if(i==bf.TurmPosX && i3 == bf.TurmPosY) {
										TableItem row = table.getItem(i);
										row.setText(i3, "T");
										
										
					    	  }
					    	  
					      }
					
					}
			          System.out.println("");
			          for (int i1 = 0;i1< 8 ;i1++) {
			              System.out.println("");
			              for (int i2 = 0;i2< 8;i2++) {
			                System.out.print(bf.Schachbrett[i1][i2] + " "); 
			              } // end of for
			            } // end of for
			          
			        } // end of if-else
			        
			      } // end of while 
			      
			    }
			}
			});
		
		btnSetzen2 = new Button(shell, SWT.NONE);
		btnSetzen2.setBounds(199, 103, 75, 25);
		btnSetzen2.setText("Setzen2");
		btnSetzen2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bf.setzen2();
				for (int i = 0;i< 8;i++) {
					
				      for (int i3 = 0;i3< 8;i3++) {
				    	  if(bf.Schachbrett[i][i3]==1) {
									TableItem row = table.getItem(i);
									row.setText(i3, "B");
									
				    	  }
				    	  if(i==bf.TurmPosX && i3 == bf.TurmPosY) {
									TableItem row = table.getItem(i);
									row.setText(i3, "T");
									
				    	  }
				      }
				
				}
			}
			});
		
		
		
		
		}
}
	
