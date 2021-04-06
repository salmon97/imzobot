package com.example.demo.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BotService {

    @Autowired
    Bot bot;

//    --1001386407092 group  chat id

    public SendMessage shareContact(Update update, String text,String text1) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText(text1);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton().setText(text);
        keyboardButton.setRequestContact(true);
        keyboardRow.add(keyboardButton);
        keyboardRows.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage saveContact_Uz(Update update,String name,String text) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage()
                .setParseMode(ParseMode.MARKDOWN)
                .setChatId(update.getMessage().getChatId());
        sendMessage.setText(text);
        String phone;
        if (update.getMessage().hasContact()) {
            phone = update.getMessage().getContact().getPhoneNumber();
        } else {
            phone = update.getMessage().getText();
        }
        String phoneNumber = phone.startsWith("+") ? phone : phone.startsWith("998") ? "+" +phone : "+998" +phone;


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow col = new KeyboardRow();
        KeyboardRow col2 = new KeyboardRow();
        KeyboardRow col3 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton(Constants.PRODUCT);
        KeyboardButton button2 = new KeyboardButton(Constants.WITH_US);
        KeyboardButton button3 = new KeyboardButton(Constants.ABOUT_US);
        KeyboardButton button4 = new KeyboardButton(Constants.ORDER);
        KeyboardButton button5 = new KeyboardButton(Constants.orqaga);
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
        SendMessage sendMessage1 = new SendMessage();
        sendMessage1.setChatId("-1001386407092");
        sendMessage1.setText("Klient \nIsmi - "+ name+"\nTel num - "+phoneNumber);
        bot.execute(sendMessage1);
        return sendMessage;
    }

    public SendMessage saveContact_Ru(Update update,String name,String text) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage()
                .setParseMode(ParseMode.MARKDOWN)
                .setChatId(update.getMessage().getChatId());
        sendMessage.setText(text);
        String phone;
        if (update.getMessage().hasContact()) {
            phone = update.getMessage().getContact().getPhoneNumber();
        } else {
            phone = update.getMessage().getText();
        }
        String phoneNumber = phone.startsWith("+") ? phone : phone.startsWith("998") ? "+" +phone : "+998" +phone;

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
        SendMessage sendMessage1 = new SendMessage();
        sendMessage1.setChatId("-1001386407092");
        sendMessage1.setText("Klient \nIsmi - "+ name+"\nTel num - "+phoneNumber);
        bot.execute(sendMessage1);
    return sendMessage;
    }

    public SendMessage order(Update update, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(text);
        return sendMessage;
    }

    public SendMessage contactWithUS(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Официальный канал «Imzo»\n" +
                "По вопросам пишите: @imzo_257_group\n" +
                "Телефон: +998952007772\n" +
                "                  +998555007772\n" +
                "\n" +
                "Facebook fb.me/@sherbek600\n" +
                "\n" +
                "Instagram: instagram.com/imzo_and");
        return sendMessage;
    }

    public SendMessage startMenuUz(Update update) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText(Constants.START_TEXT);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow col = new KeyboardRow();
        KeyboardRow col2 = new KeyboardRow();
        KeyboardRow col3 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton(Constants.PRODUCT);
        KeyboardButton button2 = new KeyboardButton(Constants.WITH_US);
        KeyboardButton button3 = new KeyboardButton(Constants.ABOUT_US);
        KeyboardButton button4 = new KeyboardButton(Constants.ORDER);
        KeyboardButton button5 = new KeyboardButton(Constants.orqaga);
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

    public SendMessage products(Update update, String text, String text1) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText(text1);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow col = new KeyboardRow();
        KeyboardRow col2 = new KeyboardRow();
        KeyboardRow col3 = new KeyboardRow();
        KeyboardRow col4 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton(Constants.quatro);
        KeyboardButton button2 = new KeyboardButton(Constants.trio);
        KeyboardButton button3 = new KeyboardButton(Constants.termo65);
        KeyboardButton button4 = new KeyboardButton(Constants.termo78);
        KeyboardButton button5 = new KeyboardButton(Constants.engerl7600);
        KeyboardButton button6 = new KeyboardButton(Constants.engerl7000);
        KeyboardButton button7 = new KeyboardButton(Constants.chempion);
        KeyboardButton orqaga = new KeyboardButton(text);
        col.add(button1);
        col.add(button2);
        col2.add(button3);
        col2.add(button4);
        col3.add(button5);
        col3.add(button6);
        col4.add(button7);
        col4.add(orqaga);
        rows.add(col);
        rows.add(col2);
        rows.add(col3);
        rows.add(col4);
        replyKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage quatro(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.q1200_1700).setCallbackData(Constants.q1200_1700 + "q");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.q1600_1800).setCallbackData(Constants.q1600_1800 + "q");

        list.add(b);
        list.add(b1);

        lists.add(list);
        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage trio600(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.tr1200_1700).setCallbackData(Constants.tr1200_1700 + "tr");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.tr1600_1800).setCallbackData(Constants.tr1600_1800 + "tr");

        list.add(b);
        list.add(b1);

        lists.add(list);
        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage termo65(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list1 = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.ter65_900_2100).setCallbackData(Constants.ter65_900_2100 + "ter65");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.ter65_900_2500).setCallbackData(Constants.ter65_900_2500 + "ter65");
        InlineKeyboardButton b2 = new InlineKeyboardButton(Constants.ter65_1200_2400).setCallbackData(Constants.ter65_1200_2400 + "ter65");

        list.add(b);
        list.add(b1);
        list1.add(b2);

        lists.add(list);
        lists.add(list1);
        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage termo78(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list1 = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.ter78_900_2100).setCallbackData(Constants.ter78_900_2100 + "ter78");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.ter78_900_2500).setCallbackData(Constants.ter78_900_2500 + "ter78");
        InlineKeyboardButton b2 = new InlineKeyboardButton(Constants.ter78_1200_2400).setCallbackData(Constants.ter78_1200_2400 + "ter78");

        list.add(b);
        list.add(b1);
        list1.add(b2);

        lists.add(list);
        lists.add(list1);
        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage engerl76(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.enger76_1200_1700).setCallbackData(Constants.enger76_1200_1700 + "enger76");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.enger76_1600_1800).setCallbackData(Constants.enger76_1600_1800 + "enger76");

        list.add(b);
        list.add(b1);


        lists.add(list);

        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage engerl70(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.enger70_1200_1700).setCallbackData(Constants.enger70_1200_1700 + "enger70");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.enger70_1600_1800).setCallbackData(Constants.enger70_1600_1800 + "enger70");

        list.add(b);
        list.add(b1);


        lists.add(list);

        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage chempion(Update update, String text) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text)
                .setParseMode(ParseMode.MARKDOWN);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list1 = new ArrayList<>();

        InlineKeyboardButton b = new InlineKeyboardButton(Constants.chempion_900_2100).setCallbackData(Constants.chempion_900_2100 + "chempion");
        InlineKeyboardButton b1 = new InlineKeyboardButton(Constants.chempion_900_2500).setCallbackData(Constants.chempion_900_2500 + "chempion");
        InlineKeyboardButton b2 = new InlineKeyboardButton(Constants.chempion_1200_2400).setCallbackData(Constants.chempion_1200_2400 + "chempion");

        list.add(b);
        list.add(b1);
        list1.add(b2);

        lists.add(list);
        lists.add(list1);
        inlineKeyboardMarkup.setKeyboard(lists);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public void chempion_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB-WBS851v6UVqXZmgFh7LGBuzk9sPAAJnsTEbY-GZSqQOvhTZ4_gtKRZwly4AAwEAAwIAA20AAyt5BwABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 246 000 sum \n\uD83D\uDCB0  2 886 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICemBgIG2sOXr1x6AlTRvkihwZgdTfAAJ4sjEbE_4BS829lJRiD_0gL0w0ny4AAwEAAwIAA20AA-Y0AgABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Максимум функциональности и эстетики для вашего бизнеса\n" +
                "-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Холодная\n" +
                "-Толщина стенки профиля - 1,1 мм\n" +
                "-Монтажная плоскость - 47 мм\n" +
                "-Максимальная высота створки - 2700 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3DZ\n" +
                "Серия Imzo Champion предназначена специально для конструкций с низким уровнем теплоизоляции, которые устанавливают в нежилые помещения. Это отличное решение для помещений, где нужны функциональные системы, легкие и удобные в монтаже, отличающиеся изящностью и плавностью форм. Конструкции из Imzo Champion дополнены качественными резиновыми уплотнителями EPDM и возможностью установки фурнитуры мировых производителей. Это обеспечит защиту от шума, пыли и влаги, а также позволяет установить различные механизмы открываний.");
        bot.execute(sendMessage);
    }

    public void chempion_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_WBS9FbvDOQqnuvfV5-nOifbweTMAAJpsTEbY-GZSq7rKQn2VyfvDqE-ni4AAwEAAwIAA20AA0PWAQABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 476 000sum \n\uD83D\uDCB0  3 282 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICemBgIG2sOXr1x6AlTRvkihwZgdTfAAJ4sjEbE_4BS829lJRiD_0gL0w0ny4AAwEAAwIAA20AA-Y0AgABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Максимум функциональности и эстетики для вашего бизнеса\n" +
                "-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Холодная\n" +
                "-Толщина стенки профиля - 1,1 мм\n" +
                "-Монтажная плоскость - 47 мм\n" +
                "-Максимальная высота створки - 2700 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3DZ\n" +
                "Серия Imzo Champion предназначена специально для конструкций с низким уровнем теплоизоляции, которые устанавливают в нежилые помещения. Это отличное решение для помещений, где нужны функциональные системы, легкие и удобные в монтаже, отличающиеся изящностью и плавностью форм. Конструкции из Imzo Champion дополнены качественными резиновыми уплотнителями EPDM и возможностью установки фурнитуры мировых производителей. Это обеспечит защиту от шума, пыли и влаги, а также позволяет установить различные механизмы открываний.");
        bot.execute(sendMessage);
    }

    public void chempion_3size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_2BS9a7szyc3MrZy04glBh9TxbA3AAJrsTEbY-GZSj4D9Qs6ejmaZWoAAZ8uAAMBAAMCAANtAANv1AEAAR4E");
        sendPhoto1.setCaption("\uD83D\uDCB0  3 845 000sum \n\uD83D\uDCB0  5 000 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICemBgIG2sOXr1x6AlTRvkihwZgdTfAAJ4sjEbE_4BS829lJRiD_0gL0w0ny4AAwEAAwIAA20AA-Y0AgABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Максимум функциональности и эстетики для вашего бизнеса\n" +
                "-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Холодная\n" +
                "-Толщина стенки профиля - 1,1 мм\n" +
                "-Монтажная плоскость - 47 мм\n" +
                "-Максимальная высота створки - 2700 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3DZ\n" +
                "Серия Imzo Champion предназначена специально для конструкций с низким уровнем теплоизоляции, которые устанавливают в нежилые помещения. Это отличное решение для помещений, где нужны функциональные системы, легкие и удобные в монтаже, отличающиеся изящностью и плавностью форм. Конструкции из Imzo Champion дополнены качественными резиновыми уплотнителями EPDM и возможностью установки фурнитуры мировых производителей. Это обеспечит защиту от шума, пыли и влаги, а также позволяет установить различные механизмы открываний.");
        bot.execute(sendMessage);
    }

    public void enger70_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAICTmBde00W4PWxp49YgY9jtUmLy1IvAAKOsjEbQ47xStXAgBrEcskYgiagoi4AAwEAAwIAA20AAztPAAIeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 200 000 sum \n\uD83D\uDCB0  2 572 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICcmBdhY54j6-y1raikpliLmjYwPwrAAKZsjEbQ47xShy0lPo0-CAvwFQumy4AAwEAAwIAA20AAzX4BAABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 5\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 70 мм\n" +
                "-Максимальная высота створки - 2300 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 24-30 мм\n" +
                "\n" +
                "Пять камер и стальной усилитель надежно держат форму, не деформируются, сохраняют тепло и защищают от шума с улицы. Серия профилей Engelberg 70 станет отличным дополнением гостиной, рабочего кабинета, библиотеки и спальни.\n" +
                "\n" +
                "Данный профиль адаптирован под климат Центральной Азии и интенсивное использование. Он выдерживает высокие перепады температуры, длительное воздействие солнечных лучей и серьёзную нагрузку. Герметичная конструкция защищает от теплопотерь, обеспечивает шумо- и влагоизоляцию. А специальное стекло пропускает больше света, чтобы в помещении было уютно в любую погоду.");
        bot.execute(sendMessage);
    }

    public void enger70_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAICUGBde1ZCP33WrbZILWIMu-fbCMn5AAKPsjEbQ47xStASISBeOyOBJICPni4AAwEAAwIAA20AA4tDAAIeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 805 000 sum \n\uD83D\uDCB0  3 300 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICcmBdhY54j6-y1raikpliLmjYwPwrAAKZsjEbQ47xShy0lPo0-CAvwFQumy4AAwEAAwIAA20AAzX4BAABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 5\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 70 мм\n" +
                "-Максимальная высота створки - 2300 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 24-30 мм\n" +
                "\n" +
                "Пять камер и стальной усилитель надежно держат форму, не деформируются, сохраняют тепло и защищают от шума с улицы. Серия профилей Engelberg 70 станет отличным дополнением гостиной, рабочего кабинета, библиотеки и спальни.\n" +
                "\n" +
                "Данный профиль адаптирован под климат Центральной Азии и интенсивное использование. Он выдерживает высокие перепады температуры, длительное воздействие солнечных лучей и серьёзную нагрузку. Герметичная конструкция защищает от теплопотерь, обеспечивает шумо- и влагоизоляцию. А специальное стекло пропускает больше света, чтобы в помещении было уютно в любую погоду.");
        bot.execute(sendMessage);
    }

    public void enger76_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAICTmBde00W4PWxp49YgY9jtUmLy1IvAAKOsjEbQ47xStXAgBrEcskYgiagoi4AAwEAAwIAA20AAztPAAIeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 743 000 sum \n\uD83D\uDCB0  3 081 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICTGBdeqjPgxpye30o_QR0BW6k5ZLLAAKJsjEbQ47xSlVs-gLMpj06W179ni4AAwEAAwIAA20AA686AgABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 6\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 76 мм\n" +
                "-Максимальная высота створки - 2300 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 32 мм\n" +
                "\n" +
                "В профилях Engelberg 76 объединены премиум-материалы, особая конструкция и современный дизайн. Новая линейка окон создаёт комфорт, делая дом светлым, уютным и тихим. Благодаря европейским стандартам производства Engelberg 76 работает бесперебойно десятки лет. Мы даем гарантию качества! Это решение для тех, кто не любит компромиссы в обустройстве дома.\n" +
                "\n" +
                "Благодаря 2-камерному стеклопакету 32 мм. с наполнением стеклопакета аргоном, окна Engelberg 76 успешно справляется с повышенным шумом. Аргон обладает лучшей теплоизоляцией и вязкостью, чем обычный воздух.\n" +
                "\n" +
                "Заполнение стеклопакетов аргоном: повышает уровень теплоизоляции (15-30%) повышает уровень звукоизоляции увеличивает срок службы стеклопакетов с энергосбережением.");
        bot.execute(sendMessage);
    }

    public void enger76_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAICUGBde1ZCP33WrbZILWIMu-fbCMn5AAKPsjEbQ47xStASISBeOyOBJICPni4AAwEAAwIAA20AA4tDAAIeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  3 573 000sum \n\uD83D\uDCB0  4 035 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICTGBdeqjPgxpye30o_QR0BW6k5ZLLAAKJsjEbQ47xSlVs-gLMpj06W179ni4AAwEAAwIAA20AA686AgABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 6\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 76 мм\n" +
                "-Максимальная высота створки - 2300 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 32 мм\n" +
                "\n" +
                "В профилях Engelberg 76 объединены премиум-материалы, особая конструкция и современный дизайн. Новая линейка окон создаёт комфорт, делая дом светлым, уютным и тихим. Благодаря европейским стандартам производства Engelberg 76 работает бесперебойно десятки лет. Мы даем гарантию качества! Это решение для тех, кто не любит компромиссы в обустройстве дома.\n" +
                "\n" +
                "Благодаря 2-камерному стеклопакету 32 мм. с наполнением стеклопакета аргоном, окна Engelberg 76 успешно справляется с повышенным шумом. Аргон обладает лучшей теплоизоляцией и вязкостью, чем обычный воздух.\n" +
                "\n" +
                "Заполнение стеклопакетов аргоном: повышает уровень теплоизоляции (15-30%) повышает уровень звукоизоляции увеличивает срок службы стеклопакетов с энергосбережением.");
        bot.execute(sendMessage);
    }

    public void termo78_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB-WBS851v6UVqXZmgFh7LGBuzk9sPAAJnsTEbY-GZSqQOvhTZ4_gtKRZwly4AAwEAAwIAA20AAyt5BwABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  4 251 000 sum \n\uD83D\uDCB0  4 964 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICSmBdeD0hDeT3GsGL2Bcqkkqa8OqdAAKFsjEbQ47xSsL4JDLIPgT2pLkQoi4AAwEAAwIAA20AAyxDAAIeBA");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 78 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация\n" +
                "Массивный “теплый“ профиль позволяет монтировать трёхстёкольный пакет с улучшенными характеристиками теплоизоляции. Кроме того, положительно влияет на звукоизоляцию окна - шума с улицы значительно стишен. В этом окне предусмотрено все: инновационная компоновка камер, стеклопакет с аргоном и энергосберегающим стеклом, современная комплектация импортной фурнитуры, исключающую продувания.Комфортно в любую погоду\n" +
                "Стеклопакет с повышенными энергосберегающими свойствами выбирают и когда необходим высокий уровень непроницаемости шума, к примеру, если дом находится рядом с аэродромом, вокзалом или другими шумными местами. Он считается самым теплым (теплоизолирующие свойства на 30-50% выше) и звукоизоляционным стеклопакетом.");
        bot.execute(sendMessage);
    }

    public void termo78_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_WBS9FbvDOQqnuvfV5-nOifbweTMAAJpsTEbY-GZSq7rKQn2VyfvDqE-ni4AAwEAAwIAA20AA0PWAQABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  4 829 000sum \n\uD83D\uDCB0  5 646 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICSmBdeD0hDeT3GsGL2Bcqkkqa8OqdAAKFsjEbQ47xSsL4JDLIPgT2pLkQoi4AAwEAAwIAA20AAyxDAAIeBA");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 78 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация\n" +
                "Массивный “теплый“ профиль позволяет монтировать трёхстёкольный пакет с улучшенными характеристиками теплоизоляции. Кроме того, положительно влияет на звукоизоляцию окна - шума с улицы значительно стишен. В этом окне предусмотрено все: инновационная компоновка камер, стеклопакет с аргоном и энергосберегающим стеклом, современная комплектация импортной фурнитуры, исключающую продувания.Комфортно в любую погоду\n" +
                "Стеклопакет с повышенными энергосберегающими свойствами выбирают и когда необходим высокий уровень непроницаемости шума, к примеру, если дом находится рядом с аэродромом, вокзалом или другими шумными местами. Он считается самым теплым (теплоизолирующие свойства на 30-50% выше) и звукоизоляционным стеклопакетом.");
        bot.execute(sendMessage);
    }

    public void termo78_3size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_2BS9a7szyc3MrZy04glBh9TxbA3AAJrsTEbY-GZSj4D9Qs6ejmaZWoAAZ8uAAMBAAMCAANtAANv1AEAAR4E");
        sendPhoto1.setCaption("\uD83D\uDCB0  6 972 000sum \n\uD83D\uDCB0  8 300 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAICSmBdeD0hDeT3GsGL2Bcqkkqa8OqdAAKFsjEbQ47xSsL4JDLIPgT2pLkQoi4AAwEAAwIAA20AAyxDAAIeBA");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 78 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация\n" +
                "Массивный “теплый“ профиль позволяет монтировать трёхстёкольный пакет с улучшенными характеристиками теплоизоляции. Кроме того, положительно влияет на звукоизоляцию окна - шума с улицы значительно стишен. В этом окне предусмотрено все: инновационная компоновка камер, стеклопакет с аргоном и энергосберегающим стеклом, современная комплектация импортной фурнитуры, исключающую продувания.Комфортно в любую погоду\n" +
                "Стеклопакет с повышенными энергосберегающими свойствами выбирают и когда необходим высокий уровень непроницаемости шума, к примеру, если дом находится рядом с аэродромом, вокзалом или другими шумными местами. Он считается самым теплым (теплоизолирующие свойства на 30-50% выше) и звукоизоляционным стеклопакетом.");
        bot.execute(sendMessage);
    }

    public void termo65_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB-WBS851v6UVqXZmgFh7LGBuzk9sPAAJnsTEbY-GZSqQOvhTZ4_gtKRZwly4AAwEAAwIAA20AAyt5BwABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  3 876 000 sum \n\uD83D\uDCB0  4 515 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAIB-2BS8-PQSe3u2IfI3igwJAaL8csTAAJosTEbY-GZSj-e6K3AfsZt59xhmi4AAwEAAwIAA20AA9YPBwABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 65 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3D\n" +
                "\n" +
                "Показатели эффективности:\n" +
                "— 3-камерный алюминиевый профиль с повышенной теплоизоляцией благодаря полиамидной термовставки\n" +
                "— Cтеклопакет наполненный аргоном и i-стеклом* с теплоотражающим покрытием для эффективной теплозащиты;— Двойной стеклопакет (опционально).Надежность и износостойкость.Вам нужны прочные окна, которые сложно сломать или деформировать? Выбирайте Engelberg Ther- mo 65. Они созданы для активного использования, устойчивы к коррозии и изменениям погоды, не боятся солнца, дождя и холода. При правильной установке безупречная работа десятилетиями гарантирована!");
        bot.execute(sendMessage);
    }

    public void termo65_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_WBS9FbvDOQqnuvfV5-nOifbweTMAAJpsTEbY-GZSq7rKQn2VyfvDqE-ni4AAwEAAwIAA20AA0PWAQABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  4 406 000sum \n\uD83D\uDCB0  5 239 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAIB-2BS8-PQSe3u2IfI3igwJAaL8csTAAJosTEbY-GZSj-e6K3AfsZt59xhmi4AAwEAAwIAA20AA9YPBwABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 65 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3D\n" +
                "\n" +
                "Показатели эффективности:\n" +
                "— 3-камерный алюминиевый профиль с повышенной теплоизоляцией благодаря полиамидной термовставки\n" +
                "— Cтеклопакет наполненный аргоном и i-стеклом* с теплоотражающим покрытием для эффективной теплозащиты;— Двойной стеклопакет (опционально).Надежность и износостойкость.Вам нужны прочные окна, которые сложно сломать или деформировать? Выбирайте Engelberg Ther- mo 65. Они созданы для активного использования, устойчивы к коррозии и изменениям погоды, не боятся солнца, дождя и холода. При правильной установке безупречная работа десятилетиями гарантирована!");
        bot.execute(sendMessage);
    }

    public void termo65_3size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAIB_2BS9a7szyc3MrZy04glBh9TxbA3AAJrsTEbY-GZSj4D9Qs6ejmaZWoAAZ8uAAMBAAMCAANtAANv1AEAAR4E");
        sendPhoto1.setCaption("\uD83D\uDCB0  7 593 000sum \n\uD83D\uDCB0  7 593 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAIB-2BS8-PQSe3u2IfI3igwJAaL8csTAAJosTEbY-GZSj-e6K3AfsZt59xhmi4AAwEAAwIAA20AA9YPBwABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - Алюминиевый\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 1,4 мм\n" +
                "-Монтажная плоскость - 65 мм\n" +
                "-Максимальная высота створки - 3000 мм\n" +
                "-Максимальная ширина створки - 1000 мм\n" +
                "-Толщина стеклопакета - 20-32 мм\n" +
                "-Покрытие - Анодирование, цвета RAL, Ламинация, Вакуум, 3D\n" +
                "\n" +
                "Показатели эффективности:\n" +
                "— 3-камерный алюминиевый профиль с повышенной теплоизоляцией благодаря полиамидной термовставки\n" +
                "— Cтеклопакет наполненный аргоном и i-стеклом* с теплоотражающим покрытием для эффективной теплозащиты;— Двойной стеклопакет (опционально).Надежность и износостойкость.Вам нужны прочные окна, которые сложно сломать или деформировать? Выбирайте Engelberg Ther- mo 65. Они созданы для активного использования, устойчивы к коррозии и изменениям погоды, не боятся солнца, дождя и холода. При правильной установке безупречная работа десятилетиями гарантирована!");
        bot.execute(sendMessage);
    }

    public void trio600_1size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAM8YEjhLoJmrXA8-kS_wlP9KWvaZIcAAvSyMRsf_khKbcYy-heFkYLLR12aLgADAQADAgADbQADVJEGAAEeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  1 686 000 sum \n\uD83D\uDCB0  2 100 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAIB4GBS7S4Ls0xgglYxYxKl0JLcveLuAAJgsTEbY-GZSuk0mfEsf41XBlhgmi4AAwEAAwIAA20AA4UUBwABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 60 мм\n" +
                "-Максимальная высота створки - 1800 мм\n" +
                "-Максимальная ширина створки - 800 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "Мы использовали проверенные годами разработки в сочетании с современными инженерными решениями — усиленный армированный профиль, стеклопакет с аргоном и энергосберегающим стеклом с теплоотражающим покрытием. Модель Imzo Trio — это сочетание классического дизайна и потрясающих параметров эффективности. Это окно, с которым ваш дом становится по-настоящему комфортным.\n" +
                "\n" +
                "Используйте максимальные возможности для оформления интерьера. Imzo Trio с технологией ламинирования LifeLike® способно подчеркнуть и дополнить самые смелые дизайнерские задумки. Каждый сможет найти вариант, наилучшим образом подходящий по стилистике помещения.");
        bot.execute(sendMessage);
    }

    public void trio600_2size(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAICF2BS95qwHWyNeUkEa6tQSGBiyOLBAAJzsTEbY-GZSmnP8PvMsD-YsSpAni4AAwEAAwIAA20AA0vHAQABHgQ");
        sendPhoto1.setCaption("\uD83D\uDCB0  2 236 000 sum \n\uD83D\uDCB0  2 695 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAAIB4GBS7S4Ls0xgglYxYxKl0JLcveLuAAJgsTEbY-GZSuk0mfEsf41XBlhgmi4AAwEAAwIAA20AA4UUBwABHgQ");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 3\n" +
                "-Толщина стенки профиля - 2,8 мм\n" +
                "-Монтажная плоскость - 60 мм\n" +
                "-Максимальная высота створки - 1800 мм\n" +
                "-Максимальная ширина створки - 800 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "Мы использовали проверенные годами разработки в сочетании с современными инженерными решениями — усиленный армированный профиль, стеклопакет с аргоном и энергосберегающим стеклом с теплоотражающим покрытием. Модель Imzo Trio — это сочетание классического дизайна и потрясающих параметров эффективности. Это окно, с которым ваш дом становится по-настоящему комфортным.\n" +
                "\n" +
                "Используйте максимальные возможности для оформления интерьера. Imzo Trio с технологией ламинирования LifeLike® способно подчеркнуть и дополнить самые смелые дизайнерские задумки. Каждый сможет найти вариант, наилучшим образом подходящий по стилистике помещения.");
        bot.execute(sendMessage);
    }

    public void quatro2(Update update) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto.setPhoto("AgACAgIAAxkBAAM-YEjhP0LaFB_RMBQmjjAWcocSdKYAAviyMRsf_khKL47YUFvhL46o9xibLgADAQADAgADbQADH3EDAAEeBA");
        sendPhoto.setCaption("\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAANAYEjhSooB7cAtE_nu4OuJhUDYxYUAAveyMRsf_khKtM_W-Uii9wtnTTSfLgADAQADAgADbQADdUMBAAEeBA");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 4\n" +
                "-Толщина стенки профиля - 2,2 мм\n" +
                "-Монтажная плоскость - 60 мм\n" +
                "-Максимальная высота створки - 1800 мм\n" +
                "-Максимальная ширина створки - 650 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "IMZO Quattro 60 — это окна с отличной пропускной способностью света. Светлое рабочее пространство воспринимается более просторным. Оно повышает продуктивность и настраивает на позитивный лад.\n" +
                "\n" +
                "Безупречные по качеству теплые окна Imzo Quattro 60 обладают сверхвысоким светопропусканием. С ними рабочие будни станут комфортными, а настроение приподнятым.");
        bot.execute(sendMessage);
    }

    public void quatro1(Update update) throws TelegramApiException {
        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto1.setPhoto("AgACAgIAAxkBAAM8YEjhLoJmrXA8-kS_wlP9KWvaZIcAAvSyMRsf_khKbcYy-heFkYLLR12aLgADAQADAgADbQADVJEGAAEeBA");
        sendPhoto1.setCaption("\uD83D\uDCB0  1 600 000 sum \n\uD83D\uDCB0  1 974 000 sum");
        bot.execute(sendPhoto1);

        SendPhoto sendPhoto3 = new SendPhoto();
        sendPhoto3.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendPhoto3.setPhoto("AgACAgIAAxkBAANAYEjhSooB7cAtE_nu4OuJhUDYxYUAAveyMRsf_khKtM_W-Uii9wtnTTSfLgADAQADAgADbQADdUMBAAEeBA");
//        sendPhoto3.setCaption("\uD83D\uDD1B 1600 ,↕️1800 boyi\n\uD83D\uDCB0 2 024 000 sum \n\uD83D\uDCB0 2 530 000 sum");
        bot.execute(sendPhoto3);

        SendMessage sendMessage = new SendMessage();
//        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("-Тип профиля - ПВХ\n" +
                "-Серия профиля - Теплая\n" +
                "-Количество камер - 4\n" +
                "-Толщина стенки профиля - 2,2 мм\n" +
                "-Монтажная плоскость - 60 мм\n" +
                "-Максимальная высота створки - 1800 мм\n" +
                "-Максимальная ширина створки - 650 мм\n" +
                "-Толщина стеклопакета - 20 мм\n" +
                "IMZO Quattro 60 — это окна с отличной пропускной способностью света. Светлое рабочее пространство воспринимается более просторным. Оно повышает продуктивность и настраивает на позитивный лад.\n" +
                "\n" +
                "Безупречные по качеству теплые окна Imzo Quattro 60 обладают сверхвысоким светопропусканием. С ними рабочие будни станут комфортными, а настроение приподнятым.");
        bot.execute(sendMessage);
    }
}