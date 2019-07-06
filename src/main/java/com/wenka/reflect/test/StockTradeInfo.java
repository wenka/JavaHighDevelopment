package com.wenka.reflect.test;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/06/11  下午 05:16
 * Description:
 */
public class StockTradeInfo {

    @Index(0)
    private String tradeType;

    @Index(1)
    private Double amtBuy;

    @Index(2)
    private Double amtSell;

    @Index(3)
    private Double amtNet;

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Double getAmtBuy() {
        return amtBuy;
    }

    public void setAmtBuy(Double amtBuy) {
        this.amtBuy = amtBuy;
    }

    public Double getAmtSell() {
        return amtSell;
    }

    public void setAmtSell(Double amtSell) {
        this.amtSell = amtSell;
    }

    public Double getAmtNet() {
        return amtNet;
    }

    public void setAmtNet(Double amtNet) {
        this.amtNet = amtNet;
    }

    @Override
    public String toString() {
        return "StockTradeInfo{" +
                "tradeType='" + tradeType + '\'' +
                ", amtBuy=" + amtBuy +
                ", amtSell=" + amtSell +
                ", amtNet=" + amtNet +
                '}';
    }
}
