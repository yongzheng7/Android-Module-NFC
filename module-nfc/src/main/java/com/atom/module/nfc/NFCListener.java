package com.atom.module.nfc;

import android.nfc.NdefMessage;

import java.util.List;

public interface NFCListener {
    public void onReceive(NdefMessage[] arrayMsg, List<Object> values);
}
