#include <iostream>

using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node()
    {
    }

    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
    }
};

class LinkedList
{
    Node *head;

public:
    LinkedList()
    {
        head = nullptr;
    }

    void push_back(int data)
    {
        Node *new_node = new Node(data);

        if (head == nullptr)
        {
            head = new_node;
            return;
        }

        Node *temp = head;

        while (temp->next != nullptr)
            temp = temp->next;

        temp->next = new_node;
    }

    void push_front(int data)
    {
        Node *new_node = new Node(data);
        new_node->next = head;

        head = new_node;
    }

    void push_index(int data, int index)
    {
        Node *new_node = new Node(data);
        Node *temp = head;

        while (--index > 0)
            temp = temp->next;

        new_node->next = temp->next;
        temp->next = new_node;
    }

    void printList()
    {
        if (head == nullptr)
            printf("Empty list\n");

        Node *temp = head;

        while (temp != nullptr)
        {
            if (temp->next == nullptr)
            {
                printf("%d\n", temp->data);
                break;
            }
            printf("%d -> ", temp->data);
            temp = temp->next;
        }
    }
};

int main()
{
    LinkedList list;

    for (int i = 6; i < 10; ++i)
        list.push_back(i);

    for (int i = 4; i > 0; --i)
    {
        list.push_front(i);
    }

    list.push_index(5, 4); // LinkedList push_index(int data, int index)

    list.printList();

    return 0;
}