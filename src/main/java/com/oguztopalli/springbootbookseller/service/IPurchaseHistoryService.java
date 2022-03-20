package com.oguztopalli.springbootbookseller.service;

import com.oguztopalli.springbootbookseller.model.PurchaseHistory;
import com.oguztopalli.springbootbookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemOfUser(Long userId);
}
