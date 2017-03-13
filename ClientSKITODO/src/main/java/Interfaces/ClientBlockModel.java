package Interfaces;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import Domaines.User;
import Services.User.AdminServicesEJBRemote;
import Services.User.ClientServicesEJB;
import Services.User.ClientServicesEJBRemote;

public class ClientBlockModel extends AbstractTableModel {
	
	 public List<User> list;
  String[] header = {"First Name","Name","Login","Email","Date of birth","Country","City","Level","Sex","Phone"};

	    
	    public ClientBlockModel() throws NamingException
	    {
	    	Object object;
			
	    	InitialContext ctx = new InitialContext();
			
			 object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/ClientServicesEJB!Services.User.ClientServicesEJBRemote");

			 ClientServicesEJBRemote proxy = (ClientServicesEJBRemote) object;

	    	list = proxy.findBlockedClient();
	    }

	    @Override
		   public String getColumnName(int column)
		    {
		       return header[column];
		   }
	    
	    
	@Override
	public int getRowCount() {
	       return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 switch(columnIndex)
	        {
	            case 0:
	                return list.get(rowIndex).getFirstName();
	            case 1 :
	                return list.get(rowIndex).getName();
	            case 2 :
	                return list.get(rowIndex).getLogin();
	            case 3 :
	                return list.get(rowIndex).getEmail();
	            case 4 :
	               return list.get(rowIndex).getDateOfBirth();
	            case 5 :
	            	return list.get(rowIndex).getCountry();
	            case 6 :
                return list.get(rowIndex).getCity();
	            case 7 :
	                return list.get(rowIndex).getLevel();
	            case 8 :
	                return list.get(rowIndex).getSexe();
	            case 9 :
	                return list.get(rowIndex).getPhone();
	            
	            default:
	                return null;
	        }   
	}

}