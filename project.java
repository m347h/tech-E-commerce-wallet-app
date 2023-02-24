

#其中，用户表存储用户基本信息，钱包表存储用户钱包余额信息对应的Java代码如下：


// User类
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    
    // 构造函数、getter和setter方法
}

// Wallet类
public class Wallet {
    private int id;
    private int userId;
    private BigDecimal balance;
    
    // 构造函数、getter和setter方法
}

// WalletService类
public class WalletService {
    private WalletDao walletDao;
    private TransactionDao transactionDao;
    
    public BigDecimal getBalance(int userId) {
        return walletDao.getBalance(userId);
    }
    
    public void consume(int userId, BigDecimal amount) {
        walletDao.consume(userId, amount);
        transactionDao.addTransaction(userId, TransactionType.CONSUME, amount);
    }
    
    public void refund(int userId, BigDecimal amount) {
        walletDao.refund(userId, amount);
        transactionDao.addTransaction(userId, TransactionType.REFUND, amount);
    }
    
    public List<Transaction> getTransactions(int userId) {
        return transactionDao.getTransactions(userId);
    }
    
    // 其他业务方法
}

// WalletDao类
public class WalletDao {
    public BigDecimal getBalance(int userId) {
        // 查询用户钱包余额
    }
    
    public void consume(int userId, BigDecimal amount) {
        // 用户消费100元
    }
    
    public void refund(int userId, BigDecimal amount) {
        // 用户退款20元
    }
    
    // 其他数据访问方法
}

// TransactionDao类
public class TransactionDao {
    public void addTransaction(int userId, TransactionType type, BigDecimal amount) {
        // 添加交易记录
    }
    
    public List<Transaction> getTransactions(int userId) {
        // 查询用户钱包金额变动明细
    }
    
    // 其他数据访问方法
}

// Transaction类
public class Transaction {
    private int id;
    private int userId;
    private TransactionType type;
    private BigDecimal amount;
    private Date createTime;
    
    // 构造函数、getter和setter方法
}

// TransactionType枚举类
public enum TransactionType {
    CONSUME,    // 消费
    REFUND      // 退款
}
