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

public class Bot extends TelegramLongPollingBot {

    KeyboardRow row = new KeyboardRow();
    KeyboardRow row1 = new KeyboardRow();
    KeyboardRow row2 = new KeyboardRow();
    KeyboardRow row3 = new KeyboardRow();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();

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
        row2.add(new KeyboardButton("Увлечения"));
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
                thread.sleep(1000);
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
            sendVideo.setVideo("BAACAgIAAxkBAAIB2F7X3iyDuf6F4SBuGaqnJu0dJ8cqAAJwCAAC0RzBSpOxwsPdnK46GgQ").setChatId(chat_id);

            try {
                execute(sendVideo);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(update.getMessage().getText().equals("Цели")){
            sendMessage.setText("Цели:");
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
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
            SendPhoto photo = new SendPhoto().setChatId(chat_id);
            photo.setPhoto("https://sun6-13.userapi.com/Hhh-pa0rHNKT79kbb1Z-8Zt9-Z-QU9KcQdswQg/h0V_lIwi8Wo.jpg");
            photo.setCaption("Олимпиада по физике");
            try {
                execute(photo);
            } catch (TelegramApiException e) {
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
