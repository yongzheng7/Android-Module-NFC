/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.atom.module.nfc;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import com.atom.module.nfc.record.SmartPoster;
import com.atom.module.nfc.record.TextRecord;
import com.atom.module.nfc.record.UriRecord;

import java.util.ArrayList;
import java.util.List;


public class NdefMessageParser {

    // Utility class
    private NdefMessageParser() {

    }

    /** Parse an NdefMessage */
    public static List<Object> parse(NdefMessage message) {
        return getRecords(message.getRecords());
    }

    public static List<Object> getRecords(NdefRecord[] records) {
        List<Object> elements = new ArrayList<Object>();
        for (final NdefRecord record : records) {
            if (UriRecord.isUri(record)) {
                elements.add(UriRecord.parse(record));
            } else if (TextRecord.isText(record)) {
                elements.add(TextRecord.parse(record));
            } else if (SmartPoster.isPoster(record)) {
                elements.add(SmartPoster.parse(record));
            } else {
            	elements.add(new String(record.getPayload()));
            }
        }
        return elements;
    }
}
