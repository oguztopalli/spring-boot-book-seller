package com.oguztopalli.springbootbookseller.service;

import com.oguztopalli.springbootbookseller.model.PurchaseHistory;
import com.oguztopalli.springbootbookseller.repository.IPurchaseHistoryRepository;
import com.oguztopalli.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }

}
