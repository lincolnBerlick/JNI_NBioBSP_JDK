package NBioBSPJNI;


public class NBioBSPJNI {
	
	
	
	private int codigoErro;
	
	
	static {
		System.loadLibrary("NBioBSPJNI");
	}
	
	private native void capture(FIR_Handle parametro1);
	private native int NativeOpenDevice();
	
	
	
	

	//Iniciar o dispositivo
	public boolean OpenDevice()  {
		
		this.codigoErro = new NBioBSPJNI().NativeOpenDevice();	
		
		return false ? isErrorOccurred() : true;
		

	}
	
	public void captureDigital(FIR_Handle parametro1) {
		
		new NBioBSPJNI().capture(parametro1);
		
	}
	
	
	public int GetErrorCode() {
		
		return this.codigoErro;
		
	}
	

	private boolean  isErrorOccurred() {
		
		return this.codigoErro != 0;
		
		
	}
	
	
	
	
	public class FIR_Handle {
		
		private long Handle = 0L;
		
		
		
		
	}
	
	


	

}
