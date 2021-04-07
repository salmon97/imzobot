package com.example.demo.bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    BotService botService;

    @Autowired
    Ru ru;

    int level = 0;

    boolean uz = true;

    String name = "";

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage()) {
            if (!update.getMessage().getChat().getId().toString().startsWith("-")){
                if (update.getMessage().hasText()) {
                    String data = update.getMessage().getText();
                    if (data.equals("/start")) {
                        level = 99;
                    }
                    if (data.equals(Constants.RU)) {
                        uz = false;
                        level = 1;
                    }
                    if (data.equals(Constants.UZ)) {
                        uz = true;
                        level = 1;
                    }
                    if (data.equals(Constants.PRODUCT) || data.equals(Constants.PRODUCT_Ru)) {
                        level = 2;
                    }
                    if (data.equals(Constants.WITH_US) || data.equals(Constants.WITH_US_Ru)) {
                        level = 4;
                    }
                    if (data.equals(Constants.ORDER) || data.equals(Constants.ORDER_Ru)) {
                        level = 11;
                    }

                    if (data.equals(Constants.orqaga) || data.equals(Constants.nazad)) {
                        if (level == 1) {
                            level = 99;
                        } else {
                            level = 1;
                        }
                    }
                    if (data.equals(Constants.quatro)) {
                        level = 3;
                    }
                    if (data.equals(Constants.termo65)) {
                        level = 6;
                    }
                    if (data.equals(Constants.termo78)) {
                        level = 7;
                    }
                    if (data.equals(Constants.chempion)) {
                        level = 10;
                    }
                    if (data.equals(Constants.engerl7000)) {
                        level = 9;
                    }
                    if (data.equals(Constants.engerl7600)) {
                        level = 8;
                    }
                    if (data.equals(Constants.trio)) {
                        level = 5;
                    }

                }
            }
        }
        if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (data.equals(Constants.q1200_1700 + "q")) {
                level = 0;
                botService.quatro1(update);
            }
            if (data.equals(Constants.q1600_1800 + "q")) {
                level = 0;
                botService.quatro2(update);
            }
            if (data.equals(Constants.tr1200_1700 + "tr")) {
                level = 0;
                botService.trio600_1size(update);
            }
            if (data.equals(Constants.tr1600_1800 + "tr")) {
                level = 0;
                botService.trio600_2size(update);
            }
            if (data.equals(Constants.ter65_900_2100 + "ter65")) {
                level = 0;
                botService.termo65_1size(update);
            }
            if (data.equals(Constants.ter65_900_2500 + "ter65")) {
                level = 0;
                botService.termo65_2size(update);
            }
            if (data.equals(Constants.ter65_1200_2400 + "ter65")) {
                level = 0;
                botService.termo65_3size(update);
            }
            if (data.equals(Constants.ter78_900_2100 + "ter78")) {
                level = 0;
                botService.termo78_1size(update);
            }
            if (data.equals(Constants.ter78_900_2500 + "ter78")) {
                level = 0;
                botService.termo78_2size(update);
            }
            if (data.equals(Constants.ter78_1200_2400 + "ter78")) {
                level = 0;
                botService.termo78_3size(update);
            }
            if (data.equals(Constants.enger76_1200_1700 + "enger76")) {
                level = 0;
                botService.enger76_1size(update);
            }
            if (data.equals(Constants.enger76_1600_1800 + "enger76")) {
                level = 0;
                botService.enger76_2size(update);
            }
            if (data.equals(Constants.enger70_1200_1700 + "enger70")) {
                level = 0;
                botService.enger70_1size(update);
            }
            if (data.equals(Constants.enger70_1600_1800 + "enger70")) {
                level = 0;
                botService.enger70_2size(update);
            }
            if (data.equals(Constants.chempion_900_2100 + "chempion")) {
                level = 0;
                botService.chempion_1size(update);
            }
            if (data.equals(Constants.chempion_900_2500 + "chempion")) {
                level = 0;
                botService.chempion_2size(update);
            }
            if (data.equals(Constants.chempion_1200_2400 + "chempion")) {
                level = 0;
                botService.chempion_3size(update);
            }
        }
        switch (level) {
            case 99:
                execute(ru.ruUz(update));
                break;
            case 1:
                if (uz)
                    execute(botService.startMenuUz(update));
                else
                    execute(ru.startMenuRu(update));
                break;
            case 2:
                if (uz)
                    execute(botService.products(update, Constants.orqaga, Constants.product_us));
                else
                    execute(botService.products(update, Constants.nazad, Constants.product_us_ru));
                break;
            case 3:
                if (uz)
                    execute(botService.quatro(update, Constants.olchov));
                else
                    execute(botService.quatro(update, Constants.olchov_ru));
                break;
            case 4: // biz bilan aloqa
                execute(botService.contactWithUS(update));
                break;
            case 5:
                if (uz)
                    execute(botService.trio600(update, Constants.olchov));
                else
                    execute(botService.trio600(update, Constants.olchov_ru));
                break;
            case 6:
                if (uz)
                    execute(botService.termo65(update, Constants.olchov));
                else
                    execute(botService.termo65(update, Constants.olchov_ru));
                break;
            case 7:
                if (uz)
                    execute(botService.termo78(update, Constants.olchov));
                else
                    execute(botService.termo78(update, Constants.olchov_ru));
                break;
            case 8:
                if (uz)
                    execute(botService.engerl76(update, Constants.olchov));
                else
                    execute(botService.engerl76(update, Constants.olchov_ru));
                break;
            case 9:
                if (uz)
                    execute(botService.engerl70(update, Constants.olchov));
                else
                    execute(botService.engerl70(update, Constants.olchov_ru));
                break;
            case 10:
                if (uz)
                    execute(botService.chempion(update, Constants.olchov));
                else
                    execute(botService.chempion(update, Constants.olchov_ru));
                break;
            case 11:
                if (!update.getMessage().getChat().getId().toString().startsWith("-")){
                    if (uz)
                        execute(botService.order(update, Constants.enter_name));
                    else
                        execute(botService.order(update, Constants.enter_name_ru));
                    level = 12;
                }
                break;
            case 12:
                if (update.hasMessage()) {
                    if (!update.getMessage().getChat().getId().toString().startsWith("-")){
                        if (update.getMessage().hasText()) {
                            name = update.getMessage().getText();
                            if (uz)
                                execute(botService.shareContact(update, Constants.SHARE_CONTACT_UZ, Constants.SHARE_CONTACT_TEXT_UZ));
                            else
                                execute(botService.shareContact(update, Constants.SHARE_CONTACT_RU, Constants.SHARE_CONTACT_TEXT_RU));
                            level = 13;
                        }
                    }
                }
                break;
            case 13:
                if (!update.getMessage().getChat().getId().toString().startsWith("-")){
                    if (uz)
                        execute(botService.saveContact_Uz(update, name, Constants.FINISH_TEXT_UZ));
                    else
                        execute(botService.saveContact_Ru(update, name, Constants.FINISH_TEXT_RU));
                }
                level = 0;
                break;
        }
    }

    @Override
    public String getBotUsername() {
        return "imzoandijon_BOT";
    }

    @Override
    public String getBotToken() {
        return "1677304570:AAG7y0TMb4XUBD1nvcbQxuwuryUJTbXeblg";
//        1677304570:AAG7y0TMb4XUBD1nvcbQxuwuryUJTbXeblg imzoandijon_BOT
//        1176443139:AAFSkJNZVUUrumJUNhII2AAiKvoc9alcmmk myFood1_bot
//        1633731938:AAEKj4tysrkx9gMxh01dMNYTLFNNqhGQvOA tests01_bot
    }
}
