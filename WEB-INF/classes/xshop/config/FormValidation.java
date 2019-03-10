package xshop.config;

public class FormValidation{
	String Err;
	public FormValidation(){
		this.Err="";
	}
	
	public String getErrors(){
		return this.Err;
	}
	
	public void setErrors(String Errmsg){
		this.Err+="<br/>"+Errmsg; 
	}
	
	public boolean requiredValidation(String value,String Errmsg){
		if(value==null || value.equals("")){
			this.Err+="<br/>"+Errmsg; 
			return false;
		}
		else{
			return true;
		} 
	}
	
	public boolean passwordMatchValidation(String password,String cpassword){
		if(!this.requiredValidation(cpassword,"Confirm Password Required")){ 
			return false;
		}
		else{
			if(password.equals(cpassword)){
				return true;
			}
			else{
				this.Err+="<br/>Password not matched";
				return false;
			}
		} 
	}
	
	public boolean passwordvalidation(String password){
		
		if (!this.requiredValidation(password,"New Password Required")){
			return false;
		}
		else{
			if(password.length()<8){
				this.Err+="<br/>Password length should minimum 8 charcter";
				return false;
			}
			else{
				boolean upper=false;
				boolean lower=false;
				boolean digit=false;
				boolean charcter=true;
				for(int i=0; i<password.length();i++){
					if(password.charAt(i)>='A' && password.charAt(i)<='Z'){
						upper=true;
					}
					else if(password.charAt(i)>='a' && password.charAt(i)<='z'){
						lower=true;
					}
					else if(password.charAt(i)>='0' && password.charAt(i)<='9'){
						digit=true;
					}
					else{
						charcter=false;
					}
				}
				if(upper && lower && digit){
					if(charcter){
						return true;
					}
					else{
						this.Err+="<br/>Invalid Character";
						return false;
					}
				}
				else{
					this.Err+="<br/>Password should contain at least one uppercase,one lower case,one digit";
					return false;
				}
			}
		}
	}
	
	public boolean nameValidation(String name){
		if(!this.requiredValidation(name,"Name Required")){
			return false;
		}
		else if(name.length()<2){
			this.Err+="<br/>Name must Contains at least two words";
			return false;
		}
		else if(name.charAt(0)>='a' && name.charAt(0)<='z' || name.charAt(0)>='A' && name.charAt(0)<='Z'){
			boolean valid=true;
			for(int i=0;i<name.length();i++){
				if(name.charAt(i)>='a' && name.charAt(i)<='z' || name.charAt(i)>='A' && name.charAt(i)<='Z' || name.charAt(i)=='.' || name.charAt(i)==' '){
					valid=true;
				}
				else{
					valid=false;
					break;
				}
			}
			if(valid){
				return true;
			}
			else{
				this.Err+="<br/>Name is not valid";
				return false;
			}
		}
		else{
			this.Err+="<br/>Name must start with a letter";
			return false;
		}  
	}
	
	public boolean emailValidation(String email){
		if(!this.requiredValidation(email,"Email Required")){
			return false;
		}
		else{
		
			String[] em=email.split("@");
			if(em.length==2){
				String[] e=em[1].split("[.]");
				if(e.length==2){
					return true;
				}
				else{
					this.Err+="<br/>Invalid Email (missing a dot)";
					return false;
				}
			}
			else{
				this.Err+="<br/>Invalid Email(missing @)";
				return false;
			}
		} 
	}
	
	public boolean selectRadioValidation(String option,String fieldName){
		if(!this.requiredValidation(option,"Please Select a "+fieldName)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean CheckBoxValidation(String[] box,String fieldName){
		boolean check=false;
		for(int i=0;i<box.length;i++){
			if(box[i]!=null){
				check=true;
				break;
			}
			else{
				check=false;
			}
		}
		if(check ){
			return true;
		}
		else{
			this.Err+="<br/>Please Select a "+fieldName; 
			return false;
		} 
	}
	
	public boolean numberfeildValidation(String number,String feildName){
		if(!this.requiredValidation(number,feildName+" Required")){
			return false;
		}
		
		else{
			
			if(IsNumber(number)){
				return true;
			}
			else{
				this.Err+="<br/>"+feildName+" has to be a positive number";
				return false;
			}
			
		}
		
	}
	
	public boolean phoneValidation(String number){
		if(!this.requiredValidation(number,"phone/contact no Required")){
			return false;
		}
		
		else{
			
			if(number.length()<12){
				if(IsNumber(number)){
				return true;
				}
				else{
					this.Err+="<br/>Invalid Number";
					return false;
				}
			}
			else{
				this.Err+="<br/>Invalid Number";
				return false;
			}
			
		}
		
		
	}
	
	
	//need to modify
	public boolean dobValidation(String day,String month,String year){
		if(day==null || day.equals("")){
			this.Err+="<br/>Day Required";
			return false;
		}
		else if(month==null || month.equals("")){
			this.Err+="<br/>Month Required";
			return false;
		}
		else if(year==null || year.equals("")){
			this.Err+="<br/>year Required";
			return false;
		}
		else{
			String dob=day+month+year;
			if(IsNumber(dob)){
				if(day.length()==2 && Integer.parseInt(day)<=31 && month.length()==2 && Integer.parseInt(month)<=12 && year.length()==4){
					return true;

				}
				else{
					this.Err+="<br/>Invalid date format";
					return false;
				}
			}
			else{
				this.Err+="<br/>Invalid date";
				return false;
			}
			
		}
		
		
	}
	
	public boolean IsNumber(String number){
		boolean num=true;
		for(int i=0;i<number.length();i++){
			if(number.charAt(i)>='0' && number.charAt(i)<='9'){
				num=true;
			}
			else{
				num=false;
				break;
			}
		}
		if(num){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public boolean idValidation(String id){
		if(!this.requiredValidation(id,"Id Required")){
			return false;
		}
		
		else{
			
			if(IsNumber(id)){
				return true;
			}
			else{
				this.Err+="<br/>Invalid Id/ Id has to be a positive number";
				return false;
			}
			
		}
		
		
	}
	
	
}