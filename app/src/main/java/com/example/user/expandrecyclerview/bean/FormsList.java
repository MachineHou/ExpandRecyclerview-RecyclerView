package com.example.user.expandrecyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class FormsList {

    /**
     * code : 000000
     * StatusCode : 200
     * forms : [{"FormPreFill":{"Field":[{"name":"保证金退还机制"},{"name":"保证金是干什么用的"},{"name":"保证金扣除的原因"}]},"formName":"保证金规则"},{"FormPreFill":{"Field":[{"name":"如何发布0元拍"},{"name":"如何发布藏品"},{"name":"如何发布专场"}]},"formName":"店铺管理"}]
     */

    private String code;
    private int StatusCode;
    private List<FormsBean> forms;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public List<FormsBean> getForms() {
        return forms;
    }

    public void setForms(List<FormsBean> forms) {
        this.forms = forms;
    }


    public static class FormsBean {
        /**
         * FormPreFill : {"Field":[{"name":"保证金退还机制"},{"name":"保证金是干什么用的"},{"name":"保证金扣除的原因"}]}
         * formName : 保证金规则
         */

        private FormPreFillBean FormPreFill;
        private String formName;


        public FormPreFillBean getFormPreFill() {
            return FormPreFill;
        }

        public void setFormPreFill(FormPreFillBean FormPreFill) {
            this.FormPreFill = FormPreFill;
        }

        public String getFormName() {
            return formName;
        }

        public void setFormName(String formName) {
            this.formName = formName;
        }


        public static class FormPreFillBean {
            private List<FieldBean> Field;

            public List<FieldBean> getField() {
                return Field;
            }

            public void setField(List<FieldBean> Field) {
                this.Field = Field;
            }

            public static class FieldBean implements Parcelable {
                /**
                 * name : 保证金退还机制
                 */

                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {

                }
            }
        }
    }
}

