package Resources;

public interface ConfigurationReader {

    //داتا رئيسيه
	public String getR_User();
	public String getR_Password();


    //داتا عاديه
    public String getValidMobile();

    public String getValidPassword();

    public String getInValidMobile();

    public String getInValidPassword();

    public String getValidUnregisteredPhone();

    public String getBrowser();
}
