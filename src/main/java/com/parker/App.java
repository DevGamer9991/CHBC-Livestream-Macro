package com.parker;

import com.parker.facebook.GetFacebookData;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App
{
  public static final String DevKey = "AIzaSyCuumDlKGiJJdHa5IIkp5FxydAjn7zUAhY";
  // App ID: 186968813458771

  // ISO 8601 Date and Time Format: 2021-07-31T20:37

  public static String keystore = "0�\u000B\b\u0002\u0001\u00030�\n" +
          "�\u0006\t*�H��\n" +
          "\u0001\u0007\u0001��\n" +
          "�\u0004�\n" +
          "�0�\n" +
          "�0�\u0005�\u0006\t*�H��\n" +
          "\u0001\u0007\u0001��\u0005�\u0004�\u0005�0�\u0005�0�\u0005�\u0006\u000B*�H��\n" +
          "\u0001\f\n" +
          "\u0001\u0002��\u0005@0�\u0005<0f\u0006\t*�H��\n" +
          "\u0001\u0005\n" +
          "0Y08\u0006\t*�H��\n" +
          "\u0001\u0005\f0+\u0004\u0014�q������_��5Z}Wc�+\u0002\u0002'\u0010\u0002\u0001 0\f\u0006\b*�H��\n" +
          "\u0002\t\u0005 0\u001D\u0006\t`�H\u0001e\u0003\u0004\u0001*\u0004\u0010Yz(V?Et*���*�B�\u0001\u0004�\u0004��$�@�#\u0010b'��s�\u001C��B������\u0016�VA�#��R=&/2�\t�(Vt�+�!��`\u0013��ͫ�Fx\u0017�5L'XP\u0002\u000B.�\u001C���<k^h��⋳�b\u0004�\u06032 77xIR%\u001F��\u0017��3,�\u0004��c����1k��\u001F��5(\u0017�^��\u0001N�ś\u001C�\u0007D�\n" +
          "i>X\u007FM�vfw��i\u00189\u0013ǅ���r2�R��\u001B~�n�\u0003�\u000E\u000F\u0005�M�^;K!>�.\u001F�\u001Cysσ��ܪT���K9!G�E@�=�HI:���e\u000E�\u0005���vX�\u0015\f^�\u0001xI�}�\u0015ͳU�k��5�Ce.y'g5 /��\u0005�3�Ҥ#���\b\u0012�r�\n" +
          "�\u0013�]ړ��.�/�*�\u0019\u001E��b\u001Cs.��zȩ=qE��6l�o~�0\u000B�C���]�\u0013�%��͏_}��Dڐ�\u0005���Y�Z��\u0007Z����=\tT ��15�\u001Fݎ{|\u0003\u0014����F\u0017��\f���k��HE�YK�\u0018��O3�V���EKBmw\t\u001105�\u0002hcÔu6%!��L#������W�\"�v!�m\u001A2��)\u001D��J�L��.�\u001D-\u0017YhQ��\u0018�zus�/ƫ��oi&\u0016e���A!w�����/�\u0013_����\u001C\u0018�\u0019�����ӑ�!p�SX�D\\�d�*�\u0003י\u001E����R��'�EjZ\u0016�pq�\n" +
          "^�: w\u0018@\u0001ww�3�i��<\u0004��\u0014\u0003\u001F,\u0016�-t,��V6\u000E\u0012c~��#\u001BO���,%\u000B[r��9�m.�ٷ��\u0005H]\u001AC�\n" +
          "��\\t�\u001FE5�1Z����O��\"���!\u0017\u001Aa.�&�\u000E� fۮK�\n" +
          "�8�x�]j?j�)�\u000B��.O�S�z�Ѡ�\u001B�\b�\u0083c*\u001D��O�\u0007S�\u0002�^��X�Zc�H\u0011iVs#3]2�C���/\u0002���r?p�Z��r&k�H5U����E��\u0007w![�\t&�Eө��\u0010�4|�DI*�Fht �]�����U���\n" +
          "����/رz0лY�#l]3���M\u001C��wſ�N;l��U�����mA\u0003mx�F\u0001ܯQy��m�\u001B�#h4g���3;f��Cx\t\u0007\u0019�]Tɽ`Nn��t}�\u0007$��F\u0004v\f��h\u0081\u001B�\u000Ba���.d�[o��e2\u0011T���\u00199�t\u0003\u0012H�\u00035��.r��>�\f�n\u0001Z\u07FE4\u0006pS \t\u0005Չ1\b\u0015~\u007F\u0011��Bv��1=\u0002\u0017\u0007����Q���`\u0006�\u0011�\u0002��7���mf\u0003?(�eڹ�.�$����*\u0001K\u000F4�ȃ�o\u0011>(��mps\u001B\u0012�3\u001C��S�-�}+\\����/�d?�\u001A&\u0015�0~d�\u0010�\u0007E&�\n" +
          "Rޣ�\u001B�%B����G��*�<^}3^o\u0007��KxM��O\u0013ҽΈfA�%\u007F�Lo9\u0015'ȉ^;�\f��)}\u001Fnr��(�\u001F\u001F�2ϧ�4]���k\u00052�^ض�qvl��.u2���V21�:�vb���w��w돻����y构�Ҩ\u0006�9����\u0018�nB^8(&f�\\ě��r\u0017\u0013%\u000E�%\u001A�'�_6\u0605U�]Wƚ�\u001D6'\u0016~\b�1D0\u001F\u0006\t*�H��\n" +
          "\u0001\t\u00141\u0012\u001E\u0010 k e y s t o r e0!\u0006\t*�H��\n" +
          "\u0001\t\u00151\u0014\u0004\u0012Time 16273311857370�\u0004�\u0006\t*�H��\n" +
          "\u0001\u0007\u0006��\u0004�0�\u0004�\u0002\u0001 0�\u0004�\u0006\t*�H��\n" +
          "\u0001\u0007\u00010f\u0006\t*�H��\n" +
          "\u0001\u0005\n" +
          "0Y08\u0006\t*�H��\n" +
          "\u0001\u0005\f0+\u0004\u0014�8�-�1�)�!;�5IWsE�H�\u0002\u0002'\u0010\u0002\u0001 0\f\u0006\b*�H��\n" +
          "\u0002\t\u0005 0\u001D\u0006\t`�H\u0001e\u0003\u0004\u0001*\u0004\u0010��0\u0016�V�Wm6�\u0010l�fD��\u0004Pv���\u0018\u0002\u0012ӣ�ḺvS�_C`w�\u001F\u000F�@��eb���1X\u0017\u001D�RH(�{�DJ���E,��\u0002S� ��]dny��S\u0003�Β8\u0018yɫ��On�\u001C���Z���a��5��\u0006W^B�m���U�\u000Fe@�\u0017�u|��\u000B�N����\u0019y5~O�C\u00153\u007F$�'�v���\u0014v�ۧL�1C��\u001AFL\u0016>H�\f>�\u0011\u0019(}IT���C�\u0001����(\u001Cߠ(5\n" +
          "�\"\u0016� �p_�1;�c���]� v���7v���㤚�Sz�s�\n" +
          "��@�<\u0007��8}l\u0001�\u0016v��Y��wWb��h��)Yd�;b4��\"�\u0002m����͟���$v�L%\u0005ךQ\u0005\u0018P`�>o\u0014y\u0013\u0013\u0001ܷ,o���M[�Q憼��\u05FAR��?ѧ���\u001E��X�\u0010�Xл����\u0001\u0004�\u0014@P�\u001A\u000B������mE��?���d�ְq<\u0002�n�Ͱ�h�Z�f� w\u00162י%��V�\u001E��(~v�\\��b~ֲ�g�\u0017\n" +
          "Ɔ�v\u07BC���&J�>Y�+�V4yj`l�\u001D@}Z\u0016�C)�KzT��\u000F�J=���H��H�\u001F�̱w-fe�\n" +
          "?2�s]r�\u0018�\n" +
          "]7s(k\u058C'�\u05ED�>���x��)��퀥\u0015�D���r\u000B�i�;�\u0010\n" +
          "�D���\tk\f\">�\u000E��Q\u0016\u0010\n" +
          "\u001F��,�G��h.��(�DЀ�\u0004�L�ߢ�\u0014$�D�([f�\u0006W��֜��\u0001�s�\n" +
          "��@�D��*��z˒\"���\" /��\u0005I��P���R�W����(:\n" +
          "��R�L\u001C'�\"j�\u0012d\u0013G\u0010�#�\u0019#Ix��Jh����\bC\b\u0017������#�7�U��e<t��/C�n\"�o���>���b�_�]\u001E�:�w�_�-���\b#9\n" +
          "\n" +
          "]�>:]7�X���_���F��o{b:��\n" +
          "2e�O�M|��\b�\u00194?��ED�#6^�}#LK�\u001C\u000B?��f��2�o�\u0019\u0001��\u0007�\u001A����J�8��9�WH�+��\u000F3@/�_f#�\u0012�wŝ\u001C�\u0013>���\u001B�W\u0002J7��\\\u0010}�G�\u001F\u0012�K*\\��9} ~G\u0010$��?�wN�\"�\u0010i��\u0012�j�^3�\u001D?C=�I\u0014^�\u0017�3j��L�\n" +
          "J1杖�gZ\n" +
          "!D\u001Bp���WKI��\u0005�Q�����H�x�\u000Fއ�qJ\u000F�5\u0012H�Dh5̷�ޕ�N����N�`��\u0015<$�|�j\n" +
          "A4�v\u0001����\u001D��-�Y\b ë�\u0003R\u0001Fr�c�f\u0010�r��D�ŗGb�)\u0007\f��{�\u0005\u0018�;��}o�Xm��I�\u0005�ߝ�\t\u001C!\u001B\u00148�j\"�i�2�L>�6�ӛ�w.\n" +
          "x�M����X\u001B���4;i��\u001Bl,�2��)��Ac4\br[��f0M010\n" +
          "\u0006\t`�H\u0001e\u0003\u0004\u0002\u0001\u0005 \u0004 �s��\u0001f���\u0019\u001E��E�dt\u000F\u0001��\u001BR�\u0001X�s\u001A�R\u0004\u0014� \u0012�/:Zɚґ�N\u0001��Wz=\u000F\u0002\u0002'\u0010";

  public static String osDir;

  public static void main(String[] args) throws Exception {
    try {
      for (Object o : args) {
        if (o.toString().equals("-l")) {
          Logger.consoleEnabled = true;
          Logger.println("Debug Logging Enabled");
        }
      }
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }

    osDir = ConfigManager.chechArch();
    Logger.println(osDir);

    ConfigManager.createContainer(osDir);

    new GetFacebookData().checkDataFile();
    new GetFacebookData().checkKeystore("keystore.jks");
    new HTTPSServer().startServer();
  }
}