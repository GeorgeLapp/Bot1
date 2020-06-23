import org.checkerframework.checker.units.qual.K;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Bot extends TelegramLongPollingBot  {

    KeyboardRow row = new KeyboardRow();
    KeyboardRow row1 = new KeyboardRow();
    KeyboardRow row2 = new KeyboardRow();
    KeyboardRow row3 = new KeyboardRow();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
    boolean s = true;

    int x=0;
    int y=0;
    public void buttons(){

        row.add(new KeyboardButton("Видео"));
        row.add(new KeyboardButton("Достижения"));
        row.add(new KeyboardButton("Цели"));
    }
    public void buttons2(){

        row1.add(new KeyboardButton("Школа"));
        row1.add(new KeyboardButton("Спорт"));
        row2.add(new KeyboardButton("Программирование"));
        row2.add(new KeyboardButton("Другое"));
        row3.add(new KeyboardButton("Назад"));

    }

    public void onUpdateReceived(Update update) {
        Thread thread = new Thread();
        if (x == 0) {
            x++;
            buttons();
        }
        if (y == 0) {
            y++;
            buttons2();
        }

        ArrayList<KeyboardRow> keyboardRowslist = new ArrayList<>();
        keyboardRowslist.add(row);
        ArrayList<KeyboardRow> keyboardRowslist1 = new ArrayList<>();
        keyboardRowslist1.add(row1);
        keyboardRowslist1.add(row2);
        keyboardRowslist1.add(row3);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowslist);
        replyKeyboardMarkup1.setResizeKeyboard(true);
        replyKeyboardMarkup1.setSelective(true);
        replyKeyboardMarkup1.setKeyboard(keyboardRowslist);


        String chat_id = String.valueOf(update.getMessage().getChatId());
        SendMessage sendMessage = new SendMessage().setChatId(chat_id);

        if (update.getMessage().getText().equals("/start")) {
            sendMessage.setText("Здравствуйте!");
            try {


                execute(sendMessage);
                thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendMessage.setText("Я - телеграмм бот, созданный Георгием Лаппом для презентации в конкурсе Большая перемена");
            try {
                execute(sendMessage);
                thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            sendMessage.setText("Пожалуйста, выберите,с чего бы вы хотели начать презентацию?");
            try {
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (update.getMessage().getText().equals("Видео")) {
            SendVideo sendVideo = new SendVideo();
            sendVideo.setVideo("BAACAgIAAxkBAAIHwV7yIzjo-lRE-8MUiNXf6rra0NCNAAIzCQACOiGQSyrE8fPxDaGzGgQ").setChatId(chat_id);

            try {
                execute(sendVideo);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(update.getMessage().getText().equals("Цели")){
            sendMessage.setText("Цели преследуемые мной:");
            try {
                execute(sendMessage);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendMessage.setText("1. Победить в конкурсе \"Большая перемена\".");
            try {
                execute(sendMessage);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendMessage.setText("2. Реализовать свой проект, который будет решать актуальные проблемы.");
            try {
                execute(sendMessage);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendMessage.setText("3. Получить хороший опыт, развить свои навыки, выйти на новый уровень. ");
            try {
                execute(sendMessage);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendMessage.setText("4. Улучшить навыки работы в команде");
            try {
                execute(sendMessage);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }








        }
        if (update.getMessage().getText().equals("Достижения")) {
            sendMessage.setText("Пожалуйста, выберите категорию");
           if(row1.size()+row2.size()+row3.size()==0){

           }
            replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
            sendMessage.setReplyMarkup(replyKeyboardMarkup1);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
        if(update.getMessage().getText().equals("Назад")){
            sendMessage.setText("Вы вернулись в главное меню");
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
        if (update.getMessage().getText().equals("Школа")) {
            sendMessage.setText("Олимпиады:");
            try {
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            SendPhoto photo = new SendPhoto().setChatId(chat_id);

            photo.setPhoto("https://sun6-13.userapi.com/Hhh-pa0rHNKT79kbb1Z-8Zt9-Z-QU9KcQdswQg/h0V_lIwi8Wo.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun6-19.userapi.com/io8D64AsCIIY9j-tejK8s0x8906xOE-FbAcXZg/bjI13c4CYi0.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun6-13.userapi.com/RpZC6zCvQ-DM9TDZrlTf-GA5BhYmQ6Opaut3lA/lew60qTujBg.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun6-19.userapi.com/QYnm42o0TIXUeH0coC-zx5HGYixxwPRdCurwBA/LXXceae2i0I.jpg");

            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            sendMessage.setText("Премии:");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            photo.setPhoto("https://sun6-14.userapi.com/Z1R8cGpqJ-5N_lr69belhFZHg4dWsD2JhuxA_w/sjZLggJKV_o.jpg");

            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //уже сделано

            photo.setPhoto("https://sun6-13.userapi.com/R-Ai3AY92KMfbvduWoFi1kgCTMOT8UxbqSbCWQ/zggL29NLw3o.jpg");

            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            photo.setPhoto("https://sun1-26.userapi.com/2KooGqf3O1fWYDE7IU7EdxhqTJQ5J5BF1QUY8A/ngv3oh3zCx4.jpgg");

            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }
        if(update.getMessage().getText().equals("Спорт")){
            SendPhoto photo = new SendPhoto().setChatId(chat_id);

            photo.setPhoto("https://sun6-13.userapi.com/LwAtCMQ1KEewqg2AuEO6EGZ9ER-HbREPItW2Aw/CHA-H6N9oqI.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




            photo.setPhoto("https://sun1-30.userapi.com/M5q1DgpNMmsLBo2j5yaRjjOJFOiCPx-NlB7-WA/C8VTIY30E1A.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            photo.setPhoto("https://sun1-93.userapi.com/UT2sfrdX562qz0HPhwXdAhIT-s2fE8sXfoQDdQ/CTMGiqprg7s.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            photo.setPhoto("https://sun1-91.userapi.com/smpmbZrc7vvqtJvglbvLDvlKbShjwzzep_gPdQ/4DfJn-VVQ-0.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            photo.setPhoto("https://sun1-84.userapi.com/nocHFfk12Ng3AiQVjgMbqEJGZskLPW--o-pA_Q/ndi9xl6X9bc.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            photo.setPhoto("https://sun1-47.userapi.com/A1A5Y09--TVDQfip6kbHAjbNln7wcmAYipuvZA/FQBsGA9LCBw.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        if(update.getMessage().getText().equals("Программирование")){

            SendPhoto photo = new SendPhoto().setChatId(chat_id);

            photo.setPhoto("https://sun6-16.userapi.com/kgOj_onRzIg3Gk0-J2dZTOui1vdLW0r-ajty8A/JEkaKUou7-I.jpg");
            try {

                replyKeyboardMarkup1.setKeyboard(keyboardRowslist1);
                photo.setReplyMarkup(replyKeyboardMarkup1);
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun1-83.userapi.com/28KKjMmJb5sbFPCW8iWT7M8gFip-4BDanZkiBQ/Sfy7xvrcpm4.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            photo.setPhoto("https://sun1-20.userapi.com/Cab9nU5MKN2OrJy-9UdKWRxi--olZo2QpX4Dyg/j2lukqy0AbE.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(update.getMessage().getText().equals("Другое")){

            SendPhoto photo = new SendPhoto().setChatId(chat_id);
            photo.setPhoto("https://sun1-93.userapi.com/fnL9FAD7bbngFdpDubqO_gd4_HamUBXi_dmuyQ/Zn-3veF06_c.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun6-19.userapi.com/x8sxgLjdGkMBp7EeenlLrkVC7Za4yohCIpVIew/VWTU2LLkVOA.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




            photo.setPhoto("https://sun1-47.userapi.com/laIcHAySuHxFQM7oWKY_ZwxPhEmQV85cMxEd4w/SnSRZ6rnpYU.jpg" );
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            photo.setPhoto("https://sun1-93.userapi.com/_Gk1v4zr-cuHhLG3OqiaqbsFx_03eD79gmraGA/qa2Z_EWV7GQ.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            photo.setPhoto("https://sun1-85.userapi.com/4tERueMjWlYxylAT0Iy6rR2K7-kf6c6hAcCd7g/A8WsewPzk0Y.jpg");
            try {
                execute(photo);
                Thread.sleep(1300);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }



    }

    public String getBotUsername() {
        return "FrilanceExampleBot";
    }

    public String getBotToken() {
        return "1009780375:AAE5zUAX8BtUOd7cFrvJSWyLXzBzkbcP3ts";
    }
}
