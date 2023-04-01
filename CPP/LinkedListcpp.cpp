class ListNode
{
    int val;
    ListNode *next = nullptr;

public:
    ListNode()
    {
        this->val = 0;
    }

    ListNode(int x)
    {
        this->val = x;
    }
    ListNode(int x, ListNode *next)
    {
        this->val = x;
        this->next = next;
    }
};

class MyLinkedList
{
    ListNode *head = nullptr;
    int size = 0;

public:
    MyLinkedList()
    {
        head = new ListNode();
    }

    int get(int index)
    {
        if (index < 0 || index >= size)
            return -1;
        ListNode *curr = head;
        for (int i = 0; i <= index; i++)
            curr = curr->next;
        return curr->val;
    }

    void addAtHead(int val)
    {
        ListNode *newNode = new ListNode(val);
        newNode->next = head->next;
        head->next = newNode;
        size++;
    }

    void addAtTail(int val)
    {
        ListNode *newNode = new ListNode(val);
        ListNode *curr = head;
        while (curr->next != nullptr)
            curr = curr->next;
        curr->next = newNode;
        size++;
    }

    void addAtIndex(int index, int val)
    {
        if (index > size)
            return;
        if (index < 0)
            index = 0;
        ListNode *newNode = new ListNode(val);
        ListNode *curr = head;
        for (int i = 0; i < index; i++)
            curr = curr->next;
        newNode->next = curr->next;
        curr->next = newNode;
        size++;
    }

    void deleteAtIndex(int index)
    {
        if (index < 0 || index >= size)
            return;
        ListNode *curr = head;
        for (int i = 0; i < index; i++)
            curr = curr->next;
        ListNode *temp = curr->next;
        curr->next = temp->next;
        delete temp;
        size--;
    }

    int getSize()
    {
        return size;
    }

    void display()
    {
        ListNode *curr = head->next;
        while (curr != nullptr)
        {
            cout << curr->val << " ";
            curr = curr->next;
        }
        cout << endl;
    }
}