package com.tearsmart.seckill.cache;

/**
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * @author tear-smart
 * @date 2019-04-17
 */
public class InventoryProductBizImpl implements InventoryProductBiz {
    @Override
    public boolean removeInventoryProductCache(Integer productId) {
        return false;
    }

    @Override
    public boolean updateInventoryProduct(InventoryProduct inventoryProduct) {
        return false;
    }

    @Override
    public InventoryProduct loadInventoryProductCache(Integer productId) {
        return null;
    }

    @Override
    public InventoryProduct loadInventoryProductByProductId(Integer productId) {
        return null;
    }

    @Override
    public boolean setInventoryProductCache(InventoryProduct inventoryProduct) {
        return false;
    }
}
