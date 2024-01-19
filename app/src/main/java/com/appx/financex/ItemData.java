package com.appx.financex;

public class ItemData {

    public static class SettingListData
    {
        private String header;
        private String subHeader;
        private int icon;
        private String theme;
        public SettingListData(String header, String subHeader, int icon, String theme)
        {
            this.header=header;
            this.subHeader=subHeader;
            this.icon=icon;
            this.theme = theme;
        }
        public String getHeader()
        {
            return header;
        }

        public String getSubHeader()
        {
            return subHeader;
        }

        public int getIcon()
        {
            return icon;
        }

        public String getTheme()
        {
            return theme;
        }
    }
}
