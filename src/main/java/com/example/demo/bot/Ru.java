package com.example.demo.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class Ru {

    public SendMessage ruUz(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Tilni tanlang\nВыберите язык");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow col = new KeyboardRow();
        KeyboardRow col2 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton(Constants.UZ);
        KeyboardButton button2 = new KeyboardButton(Constants.RU);

        col.add(button1);
        col2.add(button2);

        rows.add(col);
        rows.add(col2);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage startMenuRu(Update update) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText(Constants.START_TEXT_Ru);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow col = new KeyboardRow();
        KeyboardRow col2 = new KeyboardRow();
        KeyboardRow col3 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton(Constants.PRODUCT_Ru);
        KeyboardButton button2 = new KeyboardButton(Constants.WITH_US_Ru);
        KeyboardButton button3 = new KeyboardButton(Constants.ABOUT_US_Ru);
        KeyboardButton button4 = new KeyboardButton(Constants.ORDER_Ru);
        KeyboardButton button5 = new KeyboardButton(Constants.nazad);
        col.add(button1);
        col.add(button2);
        col2.add(button3);
        col2.add(button4);
        col3.add(button5);
        rows.add(col);
        rows.add(col2);
        rows.add(col3);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
}
