import java.util.*;

class HospitalManagementSystem
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);// Create a scanner object to read user input
        
        System.out.println("---------------------------------------------------------------");
        System.out.println(" *  *  *  * Welcome to hospital managment system  *  *  *  *  *");
        System.out.println("---------------------------------------------------------------");
        
        
		System.out.println("enter admin name");
		String n=sc.nextLine();
		sc.nextLine();
		System.out.println("enter your email:");
		String email=sc.nextLine();
		 if(n.equals("swastik") && email.equals("sjkathiriya@gmail.com"))
		 {
			 System.out.println("you login successfully");
			 
		
        int choice=5;
            
        // Display the options of management    
        while(choice != 6)
        {
            
            System.out.println("                                         ");
            System.out.println("*   *   *   Admin Managmenet   *   *   *");
            System.out.println("                               ");
            System.out.println("---> 1. Doctor Managmenet");  
            System.out.println("                          ");        
            System.out.println("---> 2. Patient Managmenet"); 
            System.out.println("                          ");
            System.out.println("---> 3. Create Appointment");  
            System.out.println("                             ");
            
            System.out.println("---> 4. Bill Generater");  
            System.out.println("                             ");
            System.out.println("---> 5. Exit");  
            System.out.println("                             ");
            
            System.out.println("");
            System.out.println("---> please Enter the keyword:"); 
            
            
            int x=sc.nextInt();//storing user's choice
            choice=x;    
    
            String gender = "";//variables for storing patient gender
            
            // Switch statement to handle different choices        
            switch(choice)
            {    
                
                //Doctor method calling
                case 1:
                    main d=new main();
                    d.Docinfo();//calling method doctor info for adding doctor details
                    System.out.println();
                    break;
                  
                  
                //Patient Management Section
                case 2:    
                    System.out.println("==============================================");
                    System.out.println("         Patient Management Section          ");
                    System.out.println("==============================================");
                    System.out.println();
                    
                    System.out.println("Please enter patient details:");
                    System.out.println("-----------------------------");
                    
                    System.out.print("Enter Patient Name: ");
                    sc.nextLine();
                    String name1=sc.nextLine();//storing patient name
                    
                    System.out.print("Enter Patient Age: ");
                    int age1=sc.nextInt();//Storing patient age
                    
                    System.out.println();
                    System.out.println("Select Patient Gender:");
                    System.out.println("1. Male");
                    System.out.println("2. Female");
                    System.out.print("Enter choice (1 or 2): ");
                      
                    int genderChoice=sc.nextInt();//Storing gender of patient
                      
                    //Enter the choice for male & female
                    if (genderChoice == 1)
                    {
                        gender = "Male";
                    } 
                    else if (genderChoice == 2) 
                    {
                        gender = "Female";
                    }
                    else //if user has enter invalid choice
                    {
                        System.out.println("Invalid Choice. Please enter 1 for Male or 2 for Female");
                        break;
                    }
                    
                    System.out.println();
                    System.out.println("Selected Gender: "+gender);
                    System.out.println();
                    System.out.println("Patient Information Summary:");
                    System.out.println("---------------------------");
                        
                
                    //calling for patient class
                    patient p=new patient(name1,age1,genderChoice);
                    p.displayInfo();//for displaying patient info
                    System.out.println();
                    System.out.println("--> Patient Information Successfully Stored!");
                    System.out.println();
                    break;
                 
                //create Appointment
                case 3:
                    main a=new main();
                    a.adm();
                    break;
                 
                //Bills 
                case 4:
                    main b=new main();
                    b.billP();//method for creating bill 
                    break;
                
                //for exiting the loop
                case 5: 
                    System.out.println("        ");
                    System.out.println("==================");
                    System.out.println("-->  Exit....");
					System.out.println("-->  Thank you...");
                    System.out.println("==================");
                    System.out.println("                      ");
                    return;
                
                default:
                    System.out.println("Invalid choice! please try again");//if user input invalid choice
            }
        }
		 }
		 else
		 {
			 System.out.println("sorry try again");
			 System.exit(0);
		 }
		 
    }
}

//Main class for creating appointing,generatring bill and storing doctor's information
class main
{
    
    //creating appointment
    void adm()
    {
        System.out.println("                                                               ");
        System.out.println(" *  *  *  *  Create Appointment  Details  *  *  *  *  *");
        System.out.println("                                                               ");
            
        Scanner sc=new Scanner(System.in);// Create a scanner object to read user input
        System.out.println("Enter the Appointment ID(int number):");
        int AppId=sc.nextInt();//entering appointment id
        
        sc.nextLine(); // Consume newline
        System.out.println("Enter the Patient Name:");
        String patientNa=sc.nextLine();//storing patient name
        
        boolean validDate = false;
        int date = 0, month = 0, year = 0;
        
        while(!validDate) {
            System.out.println("Enter the Appointment Date (DD/MM/YYYY): ");
            String AppDate=sc.nextLine();//storing appoint date
            
            String[] dateParts = AppDate.split("/");
            if(dateParts.length == 3) {
                date = Integer.parseInt(dateParts[0]);
                month = Integer.parseInt(dateParts[1]); 
                year = Integer.parseInt(dateParts[2]);
                validDate = true;
            } else {
                System.out.println("Invalid date format! Please use DD/MM/YYYY format");
            }
        }
        
        //printing the date on proper format
        System.out.println("Date:" + date +" "+ "Month: " + month+" " + "Year: " + year +" ");
            
        System.out.println("Enter the Reason for Visit:");
        String ReasonV=sc.nextLine();//storing patient's reason for visit
        
        System.out.println("-> Do you want to go for any kind of test?");//if patient want any test
        System.out.println("---> 1.Yes");
        System.out.println("---> 2.No");
        int test=sc.nextInt();
        if(test==1)
        {
            sc.nextLine();
            System.out.println("--> Which test do you want:");
            String checkup=sc.nextLine();//storing which test they want
        }
    
        //generated appointment sucessfully
        System.out.println("                                    ");
        System.out.println("--> Appointment Sucessfully Generated!!");
        System.out.println("                             ");
        System.out.println("------------------------------------------");
    
    }
        
    // Method to generate and display the bill
    void billP()
    {
        System.out.println("                                                               ");
        System.out.println(" *  *  *  *  Bills Details  *  *  *  *  *");
        System.out.println("                                                               ");
        Scanner sc=new Scanner(System.in);// Create a scanner object to read user input
        
        System.out.println("Enter the Total Consultation Fee (in INR):");
        int consultationFee = sc.nextInt();//storing consultation fee

        System.out.println("Enter the Total Test Charges (in INR):");
        int testCharges = sc.nextInt();//storing test changes

        System.out.println("Enter the Total Medicine Cost (in INR):");
        int medicineCost = sc.nextInt();//storing medicine cost

        System.out.println("Enter any Discount/Insurance Discount (in INR):");
        int discount = sc.nextInt();//if patient has any insurance policy
        
        System.out.println("                                                  ");

        // Calculating total amount
        int insuranceDiscount = (int)(discount * 0.10);
        int medicineDiscount = (int)(medicineCost * 0.20);
        int TotalBill = consultationFee + testCharges + medicineCost;//calculating bill without any discount
        int FinalBill = TotalBill - insuranceDiscount - medicineDiscount;//calculating bill with discount
        
        //printing total bill
        System.out.println("Total Consultation Fee: " + consultationFee);
        
        System.out.println("                                      ");
        System.out.println("Total Test Charges    : " + testCharges);
        System.out.println("                                      ");
        System.out.println("Total Medicine Cost   : " + medicineCost);
        System.out.println("                                      ");
        System.out.println("Insurance Discount    : " + insuranceDiscount);
        System.out.println("Medicine Discount     : " + medicineDiscount);
        System.out.println("                                      ");
        
        //printing discounted bill if amount is less then 500000
        if(TotalBill<500000)
        {
            System.out.println("Total Bill Amount     : " + FinalBill);
        }
        else//printing bill without any discount if amount is greater then 500000
        {
            System.out.println("Total Bill Amount     : " + TotalBill);
        }
    

        //checking insurance policy valid or not
        if(TotalBill<500000){
            System.out.println("================================"); 
            System.out.println("                            ");
            System.out.println("--> Valid Insurance Policy ");
            System.out.println("                            ");
            System.out.println("================================");             
        }
        else
        {
            System.out.println("================================="); 
            System.out.println("                             ");
            System.out.println("--> Invalid to insurance policy:");
            System.out.println("                            "); 
            System.out.println("=================================="); 
        }

    
        System.out.println("                                    ");
        System.out.println("----> Bill Generated Sucessfully!!");
        System.out.println("                           ");
        System.out.println("-----------------------------------------");
    }
        
    //method for storing and displaying doctor information
    void Docinfo()
    {
        System.out.println("----------------------------------------------");
        System.out.println(" *  *  *  *  Doctor Details  *  *  *  *  *");
        System.out.println("                                                               ");
        
        Scanner sc=new Scanner(System.in);// Create a scanner object to read user input
        
        System.out.print("Enter the number of doctor details to register : ");
        int totalNumOfDocs = sc.nextInt();//entering number of doctor user want
        sc.nextLine(); // Consume newline
        
        String docNames[] = new String[totalNumOfDocs];//creating array for storing name of doctorr
        String docSpecialization[] = new String[totalNumOfDocs];//creating array for storing specialization of doctor
        int docNamesLongest = 0, docSpecializationLongest = 0;
        
        //for storing name and specialization of doctor 
        for(int i=0; i<totalNumOfDocs; i++)
        {
            //Input phase
            System.out.print("Enter the Doctor Name: ");
            String DocNa=sc.nextLine();
            System.out.print("Enter the Doctor Specialization: ");
            String DocSpecip=sc.nextLine();
            
            docNames[i] = DocNa;
            docSpecialization[i] = DocSpecip;
            
            //Finding the maximum among all the doctor names
            docNamesLongest = Math.max(docNamesLongest, DocNa.length());  
            docSpecializationLongest = Math.max(docSpecializationLongest, DocSpecip.length());
        }
        

        System.out.println("                                        ");
        System.out.println("===============   Proper Format   ================");
        System.out.println("                                         ");
        
        //for finding the longest name or doctor for printing purpose
        int maxSpaceDoc = 8 + docNamesLongest -4;//8 spaces + longest name - 4(Name tag)
        int maxSpaceSpecialization = 8 + docSpecializationLongest -14; //8 spaces + longest specialization - 14(specialization tag)
        int halfSpaceDoc = (int)Math.floor(maxSpaceDoc/2); //half spaces adding  //Examples - 7.5 = 7 le
        int halfSpaceSpecialization = (int)Math.floor(maxSpaceSpecialization/2);
        String spacesDoc = "", spacesSpecialization = "", linesDoc = "", linesSpecialization = "";
        for(int i=0; i<halfSpaceDoc; i++) {spacesDoc+=" "; linesDoc+="-"; } //converting number into spaces and lines
        for(int i=0; i<halfSpaceSpecialization; i++) {spacesSpecialization+=" "; linesSpecialization+="-"; } //converting number into spaces and lines
        
        System.out.println("                                        ");
        System.out.println("                                        ");
        System.out.println("+------------+"+linesDoc+"----"+linesDoc+"+"+linesSpecialization+"--------------"+linesSpecialization+"+");
        System.out.println("   Doctor    |"+spacesDoc+"Name"+spacesDoc+"|"+spacesSpecialization+"specialization"+spacesSpecialization+"|");
        System.out.println("+------------+"+linesDoc+"----"+linesDoc+"+"+linesSpecialization+"--------------"+linesSpecialization+"+");
        
        //printing doctor's name and specialization in proper format
        for(int i=0; i<totalNumOfDocs; i++){
            String name = docNames[i], specialization = docSpecialization[i]; 
            System.out.println("     "+(i+1)+"       |"+"    "+name+"    "+"|"+"    "+specialization+ "    "+"|");
            System.out.println("+------------+"+linesDoc+"----"+linesDoc+"+"+linesSpecialization+"--------------"+linesSpecialization+"+");
        }
        
        System.out.println("                                        ");
        System.out.println("--> Doctor Information Stored Successfully!! ");
    }
}

//person class for storing patient information
class Person
{
    String name;
    int age;
    int gender;
    String genderStr; // Added field to store gender string
    
    //parameterized constructor for storing patient info in object
    Person(String name, int age, int gender)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
        // Set gender string based on gender value
        this.genderStr = (gender == 1) ? "Male" : "Female";
    }
        
    // method for printing patient info
    void displayInfo()
    {
        // Print name with proper formatting
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + genderStr); // Print actual gender string
    }
}

class patient extends Person
{
    patient(String name, int age, int gender)
    {
        super(name, age, gender);
    }
}