/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Kerem
 */
public class OptionPane {
  public static void optionPaneChangeButton(){
      UIManager.put("OptionPane.cancelButtonText","iptal");
      UIManager.put("OptionPane.okButtonText","Tamam");
      UIManager.put("OptionPane.yesButtonText","Evet");
      UIManager.put("OptionPane.noButtonText","Hayır");
  }
  public static void showMsg(String str){
      optionPaneChangeButton();
      String msg;
     switch (str){
         case "fill":
             msg="Lütfen Tüm Alanları Doldurunuz";
             break;
             case"error":
                 msg="Bir Hata Oluştu";
                 break;
                 case"success":
                     msg="İşlem Başarı ile Gerçekleşti";
                     break;
                     case"select":
                         msg="Lütfen Tablodan Bir Seçim Yapınız";
                         break;
                     default:
                         msg=str;
                         
     }
      JOptionPane.showMessageDialog(null, msg,"DİKKAT!",JOptionPane.WARNING_MESSAGE);
  }
   public static boolean confirm(String str) {
        optionPaneChangeButton();
        String msg;
        switch (str) {
            case "sure":
                msg = "Bu İşlemi Gerçekleştirmek İstiyormusunuz?";
                break;
            default:
                msg = str;
                break;
        }
        int res = JOptionPane.showConfirmDialog(null, msg, "DİKKAT!", JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            return true;
        }
            else{
       return false;
                    }
        }
}
