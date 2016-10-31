package com.ramakhutla.ethan.conf.factories;

import com.ramakhutla.ethan.domain.ContactDetails;

import java.util.Map;

/**
 * Created by Ethon on 2016/10/28.
 */
public class ContactFactory {

    public static ContactDetails createContactDetails(Map<String,String> values)
    {
        ContactDetails contact=new ContactDetails
                .Builder(values.get("tel"))
                //.email(values.get("mail"))
                .address(values.get("address"))
                .build();
        return contact;
    }
}
