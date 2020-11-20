package com.example.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class myviewmodel extends ViewModel {
    // on cree les variable data holder pour les message
    private MutableLiveData<String> msg1;
    private MutableLiveData<String> msg2;

    public void init() {
        msg1 = new MutableLiveData<>();
        msg2 = new MutableLiveData<>();
    }

    public void SendMessageto1(String msg) {
        msg2.setValue(msg);
    }

    public void SendMessageto2(String msg) {
        msg1.setValue(msg);
    }

    public LiveData<String> GetMessageFrom1() {
        return msg1;
    }

    public LiveData<String> GetMessageFrom2() {
        return msg2;
    }
}
