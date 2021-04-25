package com.atom.module.nfc;

import android.nfc.NdefMessage;

import java.util.List;

public interface NFCListener {
    void onReceive(NdefMessage[] arrayMsg, List<Object> values);
}
