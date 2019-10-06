/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.objanimal;

import org.docksidestage.bizfw.basic.objanimal.loud.Loudable;

/**
 * The object for animal(動物).
 * @author jflute
 * @author masaki.kamachi
 */
public abstract class Animal implements Loudable {

    // DONE chikama unusedの警告が出ている、IntelliJでは出てないのかな？ (誰も使ってないので、もう削除してOK) by jflute (2019/10/06)

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final BarkProcess barkProcess;
    protected int hitPoint;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Animal() {
        hitPoint = getInitialHitPoint();
        barkProcess = getBarkProcess();
    }

    protected int getInitialHitPoint() {
        return 10; // as default
    }

    protected BarkProcess getBarkProcess() {
        return new BarkProcess();
    }

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======
    public BarkedSound bark() {
        return barkProcess.bark(this);
    }

    // DONE chikama 修行++: 「これらprotectedメソッドたちをAnimalに残した理由は？」と聞かれたらどう答える？ by jflute (2019/10/02)
    // BarkProcessクラスに移行しました。
    protected abstract String getBarkWord();

    // ===================================================================================
    //                                                                           Hit Point
    //                                                                           =========
    protected void downHitPoint() {
        --hitPoint;
        if (hitPoint == 0) {
            throw new IllegalStateException("I'm very tired, so I want to sleep" + getBarkWord());
        }
    }

    // ===================================================================================
    //                                                                               Loud
    //                                                                              ======
    @Override
    public String soundLoudly() {
        return bark().getBarkWord();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getHitPoint() {
        return hitPoint;
    }
}
