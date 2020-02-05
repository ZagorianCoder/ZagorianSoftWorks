package mainengine;

public class MainEngineFactory {

	public  IMainEngine createMainEngine(String engineType) {
		
		if(engineType.equals("MainEngine")) {
			
			return new MainEngine();
			
		}
		return null;
	}

}//end class
