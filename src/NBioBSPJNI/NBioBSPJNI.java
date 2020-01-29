package NBioBSPJNI;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class NBioBSPJNI {
	
	
	
	private int codigoErro;
	
	static boolean s_useNative;
	
	  static {
		    try {
		      System.loadLibrary("NBioBSPJNI");
		      s_useNative = true;
		      System.out.println("loadLibrary success");
		    } catch (Exception exception) {
		      s_useNative = false;
		      System.out.println(exception.getMessage());
		    } 
		  }
	
	public static class FIR_PURPOSE {
	    public static final int VERIFY = 1;
	    
	    public static final int IDENTIFY = 2;
	    
	    public static final int ENROLL = 3;
	    
	    public static final int ENROLL_FOR_VERIFICATION_ONLY = 4;
	    
	    public static final int ENROLL_FOR_IDENTIFICATION_ONLY = 5;
	    
	    public static final int AUDIT = 6;
	    
	    public static final int UPDATE = 16;
	  }
	  
	
	private static native int NativeCapture(int purpose, FIR_HANDLE parametro2, int TIMEOUT_MILI, FIR_HANDLE para4, WINDOW_OPTION window_option);
	private static native int NativeOpenDevice();
	private static native int NativeCloseDevice(short paramShort);
	private static native void NativeVerify(INPUT_FIR paramINPUT_FIR, Boolean paramBoolean, FIR_PAYLOAD paramFIR_PAYLOAD);	
	private static native int NativeVerifyMatch(INPUT_FIR paramINPUT_FIR1, INPUT_FIR paramINPUT_FIR2, Boolean paramBoolean, FIR_PAYLOAD paramFIR_PAYLOAD);
	private static native int TesteObject(Boolean b);	
	

	public  class Items {
		
		public String nome;	
		public int idade;
		
		public  int iidade = 10;
		
		
		
	}
	
	
	public int testeObjeto (Boolean b) {
		
		int a = 0;
		if(s_useNative)
		 a = NBioBSPJNI.TesteObject(b);
		
		return a;
		
		
	}
	

	//Iniciar o dispositivo
	public boolean OpenDevice()  {
		
		this.codigoErro = new NBioBSPJNI().NativeOpenDevice();	
		
		return false ? isErrorOccurred() : true;		

	}
	
	public int CloseDevice() {
		
		this.codigoErro = 1;
	    if (s_useNative)
	      this.codigoErro = NBioBSPJNI.NativeCloseDevice((short)255); 
	    return this.codigoErro;
		
	}
	
	
	//metodos captura obs sobrecarregados
	
	
	//metodo que captura e retorna apenas FIR_HANDLE
	public void Capture(FIR_HANDLE parametro1) {
		
		this.codigoErro = new NBioBSPJNI().NativeCapture(1,parametro1, -1, null, null);
		
	}
	
	
	public void Capture(int purpose, FIR_HANDLE parametro2, int TIMEOUT_MILI, FIR_HANDLE para4, WINDOW_OPTION window_option) {
		
		this.codigoErro = new NBioBSPJNI().NativeCapture(purpose, parametro2, TIMEOUT_MILI, para4, window_option);		
		
	}


	
	// fim capture
	
	
	public void Verify(INPUT_FIR paramINPUT_FIR, Boolean paramBoolean, FIR_PAYLOAD paramFIR_PAYLOAD) {
		this.codigoErro  = 1;
		
		FIR_PAYLOAD fp = new FIR_PAYLOAD();
		FIR_HANDLE fh = new FIR_HANDLE();
		WINDOW_OPTION wp = new WINDOW_OPTION();
		
		//return this.codigoErro = 
		this.NativeVerify(paramINPUT_FIR, paramBoolean, fp);
		
	}
	
	
	public int VerifyMatch(INPUT_FIR paramINPUT_FIR1, INPUT_FIR paramINPUT_FIR2, Boolean paramBoolean, FIR_PAYLOAD paramFIR_PAYLOAD) {
		
		
		this.codigoErro = this.NativeVerifyMatch(paramINPUT_FIR1, paramINPUT_FIR2, paramBoolean, paramFIR_PAYLOAD);
		
		return this.codigoErro;
		
		
		
	}
	

	  public class CAPTURED_DATA {
		    public int DeviceError = 0;
		    
		    public int ImageQuality = 0;
		    
		    public Image RawImage;
		    
		    public void NativeSetData(int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3, int param1Int4) {
		      this.DeviceError = param1Int3;
		      this.ImageQuality = param1Int4;
		      if (param1Int1 > 0 && param1Int2 > 0) {
		        BufferedImage bufferedImage = new BufferedImage(param1Int1, param1Int2, 10);
		        bufferedImage.getRaster().setDataElements(0, 0, param1Int1, param1Int2, param1ArrayOfbyte);
		        this.RawImage = null;
		        this.RawImage = bufferedImage;
		      } 
		    }
		  }
	
	public class WINDOW_OPTION {
	    public int WindowStyle = 0;
	    
	    public Component ParentWnd = null;
	    
	    public Component FingerWnd = null;
	    
	    public String JrePath = System.getProperty("java.home");
	    
	    public String CaptionMsg = null;
	    
	    public String CancelMsg = null;
	    
	    public NBioBSPJNI.CAPTURE_CALLBACK CaptureCallback = null;
	    
	    public int FPForeColorR = this.FPForeColorG = this.FPForeColorB = 0;
	    
	    public int FPBackColorR = this.FPBackColorG = this.FPBackColorB = 255;
	    
	    public int DisableFingerForEnroll0 = this.DisableFingerForEnroll1 = this.DisableFingerForEnroll2 = 0;
	    
	    public int DisableFingerForEnroll3 = this.DisableFingerForEnroll4 = this.DisableFingerForEnroll5 = 0;
	    
	    public int DisableFingerForEnroll6 = this.DisableFingerForEnroll7 = this.DisableFingerForEnroll8 = 0;
	    
	    public int DisableFingerForEnroll9 = 0;
	    
	    public int FPForeColorG;
	    
	    public int FPForeColorB;
	    
	    public int FPBackColorG;
	    
	    public int FPBackColorB;
	    
	    public int DisableFingerForEnroll1;
	    
	    public int DisableFingerForEnroll2;
	    
	    public int DisableFingerForEnroll4;
	    
	    public int DisableFingerForEnroll5;
	    
	    public int DisableFingerForEnroll7;
	    
	    public int DisableFingerForEnroll8;
	    
	    public NBioBSPJNI.CAPTURED_DATA CaptureData;
	  }
	
	

  public class FIR_PAYLOAD {
	    private byte[] Data = null;
	    
	    private String Text = null;
	    
	    public void SetData(byte[] param1ArrayOfbyte) {
	      this.Data = param1ArrayOfbyte;
	      this.Text = null;
	    }
	    
	    public void SetText(String param1String) {
	      this.Data = null;
	      this.Text = param1String;
	    }
	    
	    public byte[] GetData() {
	      return this.Data;
	    }
	    
	    public String GetText() {
	      return this.Text;
	    }
	  }
		  
	
	
	public class FIR_TEXTENCODE {
	    public String TextFIR;
	  }
	  
	
	//criar inputfir necessario para usar metodos como verify e verifymatch
	public class INPUT_FIR {
		
		private int Form;
		
		private long FIRHandle;
		
		private NBioBSPJNI.FIR_TEXTENCODE textFIR;
		
		public void SetFIRHandle (NBioBSPJNI.FIR_HANDLE param1FIR_Handle) {			
			this.Form = 2;
			this.FIRHandle = param1FIR_Handle.Handle;
			
		}
		
		public void setFIRHandle (NBioBSPJNI.FIR_TEXTENCODE param1FIR_TEXTENCODE) {			
			this.Form = 4;
			this.textFIR = param1FIR_TEXTENCODE;	
			
		}		
				
	}
	
	public class FIR_HANDLE {
		
		private long Handle = 0L;	
		
		public void getvalue() {
			System.out.println(Handle);
		}
		
				
	}
	
	
	
	public int GetErrorCode() {
		
		return this.codigoErro;
		
	}
	

	private boolean  isErrorOccurred() {
		
		return this.codigoErro != 0;
		
		
	}
	

	
	

	 public static interface CAPTURE_CALLBACK {
	    int OnCaptured(NBioBSPJNI.CAPTURED_DATA param1CAPTURED_DATA);
	  }
	
	

}
