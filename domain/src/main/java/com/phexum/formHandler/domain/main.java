package com.phexum.formHandler.domain;

import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.feature.quota.QuotaFeature;
import com.phexum.formHandler.domain.feature.quota.QuotaFeatureBuilder;

public class main {
    public static void main(String[] args) {
       /* Notification notification = new Notification() {
            @Override
            public void sendNotification(NotificationContent content) {
                System.out.println(content.toString());
                System.out.println("bildirim gönderildi");
            }
        };
        NotificationContent content = new NotificationContent(
                "a@b.com",
                "formqlite@info.com",
                "Form alındı",
                "Form elimize ulaştı, teşekkürler.");

        FeatureFunction.getReply(AccountType.FREE).reply(notification,content);*/

      /*  AccountModel accountModel = new AccountModel();
       accountModel.setName("Tugay");
        accountModel.setAccountType(AccountType.FREE);
        accountModel.setActive(true);
        accountModel.setEmail("tugay@tugay.tugay");
        accountModel.setCreatedAt(new Date()); */


       //  System.out.println(ConfigFactoryUtil.getConfig(AccountType.PRO).getQuota());
      // System.out.println(FeatureFactoryUtil.getFactory(AccountType.FREE).getSpam().detectSpam("tugay"));
       // System.out.println(FeatureFactoryUtil.getFactory(AccountType.FREE).getQuota().quota(ConfigFactoryUtil.getConfig(AccountType.PRO),10L));
       // System.out.println(FeatureFactoryUtil.getFactory(AccountType.FREE).getBill().createBill(ConfigFactoryUtil.getConfig(AccountType.PRO),accountModel));
      //  NotificationContent notificationContent = new NotificationContent("KENANA","TUGAYDAN","PARA","Altın alayım mı?");
        /* JournalModel journalModel = new JournalModel();
        journalModel.setName("KENANA");
        journalModel.setCreateDate(new Date());
        System.out.println(FeatureFactoryUtil.getFactory(AccountType.FREE).getJournal().createJournal(journalModel,5L));
        */
        QuotaFeatureBuilder quotaBuilder = new QuotaFeatureBuilder();
        QuotaFeature x = quotaBuilder.accountType(AccountType.ULTIMATE).build();
        System.out.println(x.checkQuota(50L));
    }
}
